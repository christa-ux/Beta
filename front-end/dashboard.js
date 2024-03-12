
/*Toggle switch */
document.getElementById('toggle-button').addEventListener('change', function() {
    if (this.checked) {
      console.log('Toggle is on');
    } else {
      console.log('Toggle is off');
    }
  });

  
/*Date displayed in container-account */

function formatDate(date) {
    const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    
    const dayOfWeek = days[date.getDay()];
    const dayOfMonth = date.getDate();
    const month = months[date.getMonth()];
    const year = date.getFullYear();

    let suffix = 'th';
    if (dayOfMonth === 1 || dayOfMonth === 21 || dayOfMonth === 31) {
        suffix = 'st';
    } else if (dayOfMonth === 2 || dayOfMonth === 22) {
        suffix = 'nd';
    } else if (dayOfMonth === 3 || dayOfMonth === 23) {
        suffix = 'rd';
    }

    return `${dayOfWeek} ${dayOfMonth}${suffix} of ${month} ${year}`;
}

document.getElementById('dateDisplay').innerText = formatDate(new Date());


  

/*Time display in container-account*/
function updateTime() {
    const now = new Date(); // Get the current date and time
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    // Format time to display as two digits
    hours = hours < 10 ? '0' + hours : hours;
    minutes = minutes < 10 ? '0' + minutes : minutes;
    seconds = seconds < 10 ? '0' + seconds : seconds;

    // Display the time
    document.getElementById('time-display').textContent = `${hours}:${minutes}:${seconds}`;
}

// Update the time every second
setInterval(updateTime, 1000);

// Initialize the time display when the page loads
updateTime();

