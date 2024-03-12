// You might want to add an event listener to handle the change
document.getElementById('userDate').addEventListener('change', function() {
    var selectedDate = this.value;
    console.log('Date selected:', selectedDate); // You can process the date as needed
});

document.getElementById('userTime').addEventListener('change', function() {
    var selectedTime = this.value;
    console.log('Time selected:', selectedTime); // You can process the time as needed
});
