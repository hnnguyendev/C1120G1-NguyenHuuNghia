function fibonacci() {
    let f0: number = 0;
    let f1: number = 1;
    let sum: number = f0 + f1;
    let fn: number;
    for (let index = 0; index < 8; index++) {
        fn = f0 + f1;
        f0 = f1;
        f1 = fn;
        sum += fn;
    }
    console.log(`Sum = ${sum}`);
}

fibonacci();