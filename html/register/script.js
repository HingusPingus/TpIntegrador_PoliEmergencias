document.getElementById('registroForm').addEventListener('submit', function(e) {            
    // Aquí puedes agregar la lógica para procesar el formulario
    e.preventDefault(); 
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const contacto = document.getElementById('contactoEmergencia').value;
    const obraSocial = document.getElementById('obraSocial').value;
            
    const postData = {
        'username':username,
        'password':password,
        'contactoEmergencia':parseInt(contacto),
        'obraSocialId':parseFloat(obraSocial),
    };
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' // Indicate that the body is JSON
        },
        body: JSON.stringify(postData) // Convert the data object to a JSON string
    };
    fetch('http://127.0.0.1:8080/api/usuarios', requestOptions)
        .then(response => {
            console.log('Response status:', response.status);
        console.log('Content-Type:', response.headers.get('content-type'));
        const contentType = response.headers.get('content-type');
                
        if (contentType && contentType.includes('application/json')) {
            return response.json();
        } else {
        // Si no es JSON, obtener como texto
            return response.text().then(text => {
            throw new Error(`Respuesta no JSON: ${text.substring(0, 100)}`);
            });
        }
        })
        .then(data => {
            console.log('Success:', data); // Handle the successful response data
        })
        .catch(error => {
            console.log('Error:', error); // Handle any errors during the request
        });

            
});




// Función para mostrar errores
function showError(message) {
    const errorElement = document.getElementById('errorMessage');
    errorElement.textContent = message;
    errorElement.style.display = 'block';
    
    const successElement = document.getElementById('successMessage');
    successElement.style.display = 'none';
}

// Función para mostrar éxito
function showSuccess(message) {
    const successElement = document.getElementById('successMessage');
    successElement.textContent = message;
    successElement.style.display = 'block';
    
    const errorElement = document.getElementById('errorMessage');
    errorElement.style.display = 'none';
}


