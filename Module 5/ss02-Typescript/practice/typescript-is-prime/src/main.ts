function isPrime(num: number) {
    if (num < 2) {
        return false;
    }

    for (let index = 2; index <= Math.sqrt(num); index++) {
        if (num % index === 0) {
            return false;
        }
    }
    return true;

}

let array: number[] = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sumArray: number = 0;
for (let number of array) {
    if (isPrime(number)) {
        sumArray += number;
    }
}
console.log("Sum of prime number in array: " + sumArray);
