// Verificar si ya está logueado al cargar la página
document.addEventListener('DOMContentLoaded', function() {
    const username = document.getElementById("username");
    const idUser = document.getElementById('idUser');
    const roleUser = document.getElementById('roleUser');
    const obraSocial = document.getElementById('obraSocial');
    const telefono = document.getElementById('telefono');
    

    if (typeof(Storage) !== "undefined") {
        const isLoggedIn = localStorage.getItem("isLoggedIn");
        const user = localStorage.getItem("user");
        if (isLoggedIn === "true" && user) {
            console.log('Usuario ya logueado:', JSON.parse(user));
            const name=user.name
            username.innerHTML=name;
            idUser.innerHTML=user.id;
            roleUser.innerHTML=user.role;
            
        
        }
    }
});