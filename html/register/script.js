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
        body: JSON.stringify(loginData),
        // Agregar mode y credentials para CORS
        mode: 'cors',
        credentials: 'same-origin' // o 'include' si necesitas cookies
    };
    
    // Mostrar loading
    const submitBtn = document.querySelector('.btn-login');
    const originalText = submitBtn.textContent;
    submitBtn.textContent = 'Iniciando sesión...';
    submitBtn.disabled = true;
    
    fetch('http://127.0.0.1:8080/api/login', requestOptions)
        .then(response => {
            console.log('Response status:', response.status);
            console.log('Response ok:', response.ok);
            console.log('Response headers:');
            
            // Log de todos los headers
            for (let [key, value] of response.headers.entries()) {
                console.log(`${key}: ${value}`);
            }
            
            if (!response.ok) {
                // Si hay error, obtener más detalles
                return response.text().then(text => {
                    throw new Error(`HTTP ${response.status}: ${text || response.statusText}`);
                });
            }
            
            const contentType = response.headers.get('content-type');
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text().then(text => {
                    console.log('Respuesta del servidor (texto):', text);
                    return { message: text, success: true };
                });
            }
        })
        .then(data => {
            console.log('Login successful - Data:', data);
            showSuccess('Login exitoso!');
            
            // Guardar usuario en localStorage
            loginUser(data);
            
            // Redirigir después de éxito
            setTimeout(() => {
                window.location.href = 'dashboard.html';
            }, 1500);
            
        })
        .catch(error => {
            console.error('Error completo en login:', error);
            
            // Análisis específico del error
            if (error.message.includes('405')) {
                showError('Error 405: Método no permitido. El servidor rechazó el método POST.');
                testAlternativeMethods();
            } else if (error.message.includes('CORS') || error.message.includes('NetworkError')) {
                showError('Error de CORS: El servidor no permite requests desde este origen.');
                testWithCORSProxy();
            } else if (error.message.includes('404')) {
                showError('Error 404: Endpoint no encontrado. Verifica la URL.');
            } else {
                showError('Error: ' + error.message);
            }
        })
        .finally(() => {
            // Restaurar botón
            submitBtn.textContent = originalText;
            submitBtn.disabled = false;
        });
});

// Función para probar métodos alternativos
function testAlternativeMethods() {
    console.log('Probando métodos alternativos...');
    
    const testData = {
        'username': 'test',
        'password': 'test'
    };
    
    // Probar con GET (aunque no sea lo ideal)
    fetch('http://127.0.0.1:8080/api/login', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => console.log('GET test - Status:', response.status))
    .catch(error => console.log('GET test - Error:', error));
    
    // Probar con diferentes content-types
    const formData = new URLSearchParams();
    formData.append('username', 'test');
    formData.append('password', 'test');
    
    fetch('http://127.0.0.1:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: formData
    })
    .then(response => console.log('FormData test - Status:', response.status))
    .catch(error => console.log('FormData test - Error:', error));
}

// Función para probar con proxy CORS (solo para testing)
function testWithCORSProxy() {
    console.log('Probando con proxy CORS...');
    
    const loginData = {
        'username': 'test',
        'password': 'test'
    };
    
    // Usar un proxy CORS público para testing
    const proxyUrl = 'https://cors-anywhere.herokuapp.com/';
    const targetUrl = 'http://127.0.0.1:8080/api/login';
    
    fetch(proxyUrl + targetUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => console.log('CORS Proxy test - Status:', response.status))
    .catch(error => console.log('CORS Proxy test - Error:', error));
}

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
        localStorage.setItem("loginTime", new Date().toISOString());
        
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
        localStorage.removeItem("loginTime");
        
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
            // Opcional: redirigir automáticamente
            // window.location.href = 'dashboard.html';
        }
    }
    
    // Probar la conexión al servidor al cargar la página
    testServerConnection();
});

// Función para probar la conexión al servidor
function testServerConnection() {
    console.log('Probando conexión con el servidor...');
    
    fetch('http://127.0.0.1:8080/', {
        method: 'HEAD',
        mode: 'no-cors'
    })
    .then(() => console.log('Servidor responde'))
    .catch(error => console.log('Servidor no accesible:', error));
}