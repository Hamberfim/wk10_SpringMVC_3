function validateForm() {
  var x = document.forms["registration"]["firstname"].value;
  if (x == "") {
    alert("First name must be filled out");
    return false;
  }
  
  var x = document.forms["registration"]["lastname"].value;
  if (x == "") {
    alert("Last name must be filled out");
    return false;
  }
  
  var x = document.forms["registration"]["make"].value;
  if (x == "") {
    alert("Car make must be filled out");
    return false;
  }
  
  var x = document.forms["registration"]["model"].value;
  if (x == "") {
    alert("Car model must be filled out");
    return false;
  }
  
  var x = document.forms["registration"]["color"].value;
  if (x == "") {
    alert("Car color must be filled out");
    return false;
  }
  
  var x = document.forms["registration"]["platenumber"].value;
  if (x == "") {
    alert("Car plate number must be filled out");
    return false;
  }
  
}