document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    }).then(response => response.json())
      .then(data => {
        if (data.success) {
            alert('Login exitoso!');
            window.location.href = '/stock.html'; // Redirigir a la página de inicio
        } else {
            alert('Usuario o contraseña incorrectos.');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('Ocurrió un error en el login.');
    });
});

function register() {
    const username = prompt('Ingrese su nuevo nombre de usuario');
    const password = prompt('Ingrese su nueva contraseña');

    if (username && password) {
        fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        }).then(response => response.json())
          .then(data => {
            if (data.success) {
                alert('Usuario registrado con éxito!');
            } else {
                alert('Error al registrar el usuario.');
            }
        }).catch(error => {
            console.error('Error:', error);
            alert('Ocurrió un error al registrar.');
        });
    }
}
