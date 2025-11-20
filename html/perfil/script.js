// Wait for the React app to fully render
function waitForElement(selector, timeout = 5000) {
    return new Promise((resolve, reject) => {
        const startTime = Date.now();
        
        function checkElement() {
            const element = document.querySelector(selector);
            if (element) {
                resolve(element);
            } else if (Date.now() - startTime >= timeout) {
                reject(new Error(`Element ${selector} not found within ${timeout}ms`));
            } else {
                setTimeout(checkElement, 100);
            }
        }
        
        checkElement();
    });
}

// Load user data after React renders
document.addEventListener('DOMContentLoaded', function() {
    // Wait a bit for React to render
    setTimeout(loadUserData, 1000);
});

function loadUserData() {
    const username = document.getElementById("username");
    const idUser = document.getElementById('idUser');
    const roleUser = document.getElementById('roleUser');
    const obraSocial = document.getElementById('obraSocial');
    const telefono = document.getElementById('telefono');

    console.log('Looking for elements:', { username, idUser, roleUser, obraSocial, telefono });

    if (typeof(Storage) !== "undefined") {
        const isLoggedIn = localStorage.getItem("isLoggedIn");
        const user = localStorage.getItem("user");
        
        if (isLoggedIn === "true" && user) {
            try {
                const userData = JSON.parse(user);
                console.log('Usuario ya logueado:', userData);
                
                // Set the user data in the DOM if elements exist
                if (username) username.textContent = userData.name || userData.username || 'N/A';
                if (idUser) idUser.textContent = userData.id || 'N/A';
                if (roleUser) roleUser.textContent = userData.role || 'N/A';
                if (obraSocial) obraSocial.textContent = userData.paciente.obraSocial.nombre || 'N/A';
                console.log(userData.paciente.obraSocial.nombre )
                if (telefono) telefono.textContent = userData.contactoEmergencia || 'N/A';
                console.log(userData.contactoEmergencia )

                
            } catch (error) {
                console.error('Error parsing user data:', error);
            }
        } else {
            console.log('No user logged in or user data not found');
        }
    }
}