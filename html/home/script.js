document.addEventListener('DOMContentLoaded', function() {
    // Get DOM references first    
    const especialidad = document.getElementById('specialty');

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
            })