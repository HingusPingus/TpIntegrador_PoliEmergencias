document.addEventListener('DOMContentLoaded', function() {
    // Get DOM references first
    const sede = document.getElementById('sede');
    const especialidad = document.getElementById('especialidad');
    
    if (typeof(Storage) !== "undefined") {
        const isLoggedIn = localStorage.getItem("isLoggedIn");
        const user = localStorage.getItem("user");
        
        if (isLoggedIn === "true" && user) {
            console.log('Usuario ya logueado:', JSON.parse(user));
            
            // Load especialidades
            sede.innerHTML = '<option value="">Sede</option>';
            fetch('http://127.0.0.1:8080/api/especialidades')
                .then(response => response.json())
                .then(data => {
                    especialidad.innerHTML = '<option value="">Especialidad</option>';
                    data.forEach(esp => {
                        const option = document.createElement('option');
                        option.value = esp.id;
                        option.textContent = esp.nombre;
                        especialidad.appendChild(option);
                    });
                })
                .catch(handleFetchError);

            // Load sedes
            fetch('http://127.0.0.1:8080/api/sedes')
                .then(response => response.json())
                .then(data => {
                    sede.innerHTML = '<option value="">Sede</option>';
                    data.forEach(sed => {
                        const option = document.createElement('option');
                        option.value = sed.id;
                        option.textContent = sed.nombre;
                        sede.appendChild(option);
                    });
                })
                .catch(handleFetchError);
        }
    }
});

document.getElementById('appointment-form').addEventListener('submit', function(e) {            
    e.preventDefault(); 
    
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;
    const especialidad = document.getElementById("especialidad");
    const sede = document.getElementById("sede");
    const user = JSON.parse(localStorage.getItem("user"));

    // Validate required fields
    if (!date || !time || !especialidad.value || !sede.value) {
        showError('Por favor, completa todos los campos requeridos');
        return;
    }

    // Chain the requests properly
    fetch(`http://127.0.0.1:8080/api/medicos/disponible?obraSocial=${user.paciente.obraSocial.id}&especialidad=${especialidad.value}&sede=${sede.value}&hora=${time}&fecha=${date}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al buscar médico disponible');
            }
            return response.json();
        })
        .then(data => {
            // Create appointment with the doctor ID
            const postData = {
                fecha: date,
                horario: time,
                sede: parseInt(sede.value),
                id_doctor: data.id, // Use data from current response
                idEspecialidad: parseInt(especialidad.value)
            };
            console.log(postData);
            
            return fetch('http://127.0.0.1:8080/api/turnos/usuarios?userId='+user.id, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(postData)
            });
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al crear el turno');
            }
            return response;
        })
        .then(data => {
            console.log('Success:', JSON.stringify(data));
            showSuccess('¡Turno creado exitosamente! Tu cita ha sido reservada.');
            
            // Optional: Reset the form
            document.getElementById('appointment-form').reset();
        })
        .catch(error => {
            console.error('Error:', error);
            showError('Error al crear el turno: ' + error.message);
        });
});

function handleFetchError(error) {
    console.error(error);
    if (error.message.includes('405')) {
        showError('Error: Método no permitido. Verifica la configuración del servidor.');
    } else if (error.message.includes('404')) {
        showError('Error: Endpoint no encontrado. Verifica la URL.');
    } else {
        showError(error.message);
    }
}

function showError(message) {
    const errorElement = document.getElementById('errorMessage');
    errorElement.textContent = message;
    errorElement.style.display = 'block';
    
    const successElement = document.getElementById('successMessage');
    successElement.style.display = 'none';
}

function showSuccess(message) {
    const successElement = document.getElementById('successMessage');
    successElement.textContent = message;
    successElement.style.display = 'block';
    
    const errorElement = document.getElementById('errorMessage');
    errorElement.style.display = 'none';
}