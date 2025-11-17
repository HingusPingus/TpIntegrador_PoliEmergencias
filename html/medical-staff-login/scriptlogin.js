document.getElementById('loginForm').addEventListener('submit', function(e) {            
    e.preventDefault(); 
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // Validación básica
    if (!username || !password) {
        showError('Por favor, completa todos los campos');
        return;
    }
            
    const loginData = {
        'username': username,
        'password': password
    };
    
    console.log('Enviando datos de login:', loginData);
    
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    };
    
    fetch('http://127.0.0.1:8080/api/login', requestOptions)
        .then(response => {
            console.log('Response status:', response.status);
            console.log('Response headers:', response.headers);
            
            
            const contentType = response.headers.get('content-type');
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text().then(text => {
                    throw new Error(`Respuesta no JSON: ${text.substring(0, 100)}`);
                });
            }
        })
        .then(data => {
            console.log('Login successful:', data);
            showSuccess('Login exitoso!');
            
            // Guardar usuario en localStorage
            loginUser(data);
            
            
        })
        .catch(error => {
            console.error(error);
            
            if (error.message.includes('405')) {
                showError('Error: Método no permitido. Verifica la configuración del servidor.');
            } else if (error.message.includes('404')) {
                showError('Error: Endpoint no encontrado. Verifica la URL.');
            } else {
                showError(error.message);
            }
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

function loginUser(user) {
    if (typeof(Storage) !== "undefined") {
        // Guardar el usuario completo o solo los datos necesarios
        localStorage.setItem("user", JSON.stringify(user));
        localStorage.setItem("username", user.username || user.nombre || 'Usuario');
        localStorage.setItem("isLoggedIn", "true");
        
        console.log('Usuario guardado en localStorage:', user);
    } else {
        console.error('LocalStorage no soportado');
    }
}

function logoutUser() {
    if (typeof(Storage) !== "undefined") {
        localStorage.removeItem("user");
        localStorage.removeItem("username");
        localStorage.removeItem("isLoggedIn");
        
        console.log('Usuario eliminado de localStorage');
    } else {
        console.error('LocalStorage no soportado');
    }
}

// Verificar si ya está logueado al cargar la página
document.addEventListener('DOMContentLoaded', function() {
    if (typeof(Storage) !== "undefined") {
        const isLoggedIn = localStorage.getItem("isLoggedIn");
        const user = localStorage.getItem("user");
        if (isLoggedIn === "true" && user) {
            console.log('Usuario ya logueado:', JSON.parse(user));
            // Redirigir automáticamente si ya está logueado
            // window.location.href = 'dashboard.html';
        }
    }
});