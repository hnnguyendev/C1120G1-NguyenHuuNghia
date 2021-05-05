function fibonacci1() {
    let f0: number = 0;
    let f1: number = 1;
    console.log(f0);
    console.log(f1);
    let sum: number = f0 + f1;
    let fn: number;
    for (let index = 0; index < 8; index++) {
        fn = f0 + f1;
        f0 = f1;
        f1 = fn;
        console.log(fn);
        sum += fn;
    }
    console.log(`Sum = ${sum}`);
}

fibonacci1();

function fibonacci(anyNumber: number): number {
    if (anyNumber <= 1) {
        return anyNumber;
    } else {
        return fibonacci(anyNumber - 1) + fibonacci(anyNumber - 2);
    }
}

let n: number = 10;
let fib: number;
let sum: number = 0;
for (let i = 0; i < n; i++) {
    fib = fibonacci(i);
    console.log(fib);
    sum += fib;
}

console.log(`Sum of Fibonacci = ${sum}`);