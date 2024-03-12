// Placeholder JavaScript functions for SHP module functionalities

// Function to handle "Away Mode" activation
document.getElementById('toggle-away-mode').addEventListener('change', function() {
    if (this.checked) {
        console.log("Away Mode activated");
    } else {
        console.log("Away Mode deactivated");
    }
});

// Function to set time before alerting authorities
document.getElementById('set-alert-time-btn').addEventListener('click', function() {
    var alertTime = parseInt(document.getElementById('alert-time').value);
    console.log("Time before alerting authorities set to " + alertTime + " minutes.");
});

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

  
