function isPrime(num) {
    if (num < 2) {
        return false;
    }
    for (var index = 2; index <= Math.sqrt(num); index++) {
        if (num % index === 0) {
            return false;
        }
    }
    return true;
}
var array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
var sumArray = 0;
for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
    var number = array_1[_i];
    if (isPrime(number)) {
        sumArray += number;
    }
}
console.log("Sum of prime number in array: " + sumArray);
