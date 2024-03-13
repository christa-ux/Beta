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

// Placeholder JavaScript functions for SHH module functionalities

document.addEventListener("DOMContentLoaded", function () {
    // Functionality for zone temperature settings
    var zoneInputs = document.querySelectorAll('.zone-temp');
    zoneInputs.forEach(function(input) {
        input.addEventListener('change', function() {
            console.log("Zone " + input.id.slice(-1) + " temperature set to " + input.value + "°C");
        });
    });

    // Functionality for period-based temperature settings
    var periodTimes = document.querySelectorAll('.period-time');
    var periodTemps = document.querySelectorAll('.period-temp');
    for (var i = 0; i < periodTimes.length; i++) {
        periodTimes[i].addEventListener('change', function() {
            console.log("Period " + (i+1) + " time set to " + this.value);
        });
        periodTemps[i].addEventListener('change', function() {
            console.log("Period " + (i+1) + " temperature set to " + this.value + "°C");
        });
    }
});

// Function to get indoor temperature
function getIndoorTemperature() {
    // Implement logic to fetch indoor temperature (example: from sensors)
    var indoorTemperature = 22; // Example indoor temperature in Celsius
    document.getElementById('indoor-temp-display').innerText = "Current Indoor Temperature: " + indoorTemperature + "°C";
}

// Function to get outdoor temperature
function getOutdoorTemperature() {
    // Implement logic to fetch outdoor temperature (example: from weather API)
    var outdoorTemperature = 18; // Example outdoor temperature in Celsius
    document.getElementById('outdoor-temp-display').innerText = "Current Outdoor Temperature: " + outdoorTemperature + "°C";
}

// Call functions to display indoor and outdoor temperatures
getIndoorTemperature();
getOutdoorTemperature();
