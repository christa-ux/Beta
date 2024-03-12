document.addEventListener("DOMContentLoaded", function () {
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    const currentPath = window.location.pathname;

    navLinks.forEach(link => {
        // Check if the link's href matches the current path
        if (link.getAttribute('href') === currentPath) {
            link.classList.add('active');
        }
    });
});