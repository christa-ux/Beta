// Placeholder JavaScript functions for SHP module functionalities

document.getElementById('toggle-away-mode').addEventListener('click', function() {
    var modeIndicator = document.getElementById('mode-indicator');
    if (this.classList.contains('active')) {
        this.classList.remove('active');
        this.textContent = "Enable Away Mode";
        modeIndicator.textContent = "(Off)";
        console.log("Away Mode deactivated");
    } else {
        this.classList.add('active');
        this.textContent = "Disable Away Mode";
        modeIndicator.textContent = "(On)";
        console.log("Away Mode activated");
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

  
