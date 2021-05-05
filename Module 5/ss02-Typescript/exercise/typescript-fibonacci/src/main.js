function fibonacci1() {
    var f0 = 0;
    var f1 = 1;
    console.log(f0);
    console.log(f1);
    var sum = f0 + f1;
    var fn;
    for (var index = 0; index < 8; index++) {
        fn = f0 + f1;
        f0 = f1;
        f1 = fn;
        console.log(fn);
        sum += fn;
    }
    console.log("Sum = " + sum);
}
fibonacci1();
function fibonacci(anyNumber) {
    if (anyNumber <= 1) {
        return anyNumber;
    }
    else {
        return fibonacci(anyNumber - 1) + fibonacci(anyNumber - 2);
    }
}
var n = 10;
var fib;
var sum = 0;
for (var i = 0; i < n; i++) {
    fib = fibonacci(i);
    console.log(fib);
    sum += fib;
}
console.log("Sum of Fibonacci = " + sum);
