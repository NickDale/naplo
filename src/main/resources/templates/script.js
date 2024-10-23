document.addEventListener('DOMContentLoaded', () => {
    const isLoggedIn = false; // Change to true if user is logged in

    const loginLink = document.getElementById('loginLink');
    const logoutLink = document.getElementById('logoutLink');
    const userInfo = document.getElementById('userInfo');
    const regLink = document.getElementById('regLink');
    const userName = document.getElementById('userName');

    if (isLoggedIn) {
        loginLink.style.display = 'none';
        regLink.style.display = 'none';
        logoutLink.style.display = 'inline-block';
        userInfo.style.display = 'inline-block';
        userName.textContent = "Kovács János"; // Set logged in user's name
    } else {
        loginLink.style.display = 'inline-block';
        regLink.style.display = 'inline-block';
        logoutLink.style.display = 'none';
        userInfo.style.display = 'none';
    }
});