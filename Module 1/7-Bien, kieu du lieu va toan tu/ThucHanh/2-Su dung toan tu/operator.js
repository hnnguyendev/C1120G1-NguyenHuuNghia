let inputWidth;
let inputHeight;
inputWidth = prompt("Enter the width");
inputHeight = prompt("Enter the height");
let width = parseInt(inputWidth);
let height = parseInt(inputHeight);
let area = width * height;
document.getElementById("inputWidth").innerHTML = "Enter width:<br/>" + width;
document.getElementById("inputHeight").innerHTML = "Enter height:<br/>" + height;
document.write("The area is: " + area);

