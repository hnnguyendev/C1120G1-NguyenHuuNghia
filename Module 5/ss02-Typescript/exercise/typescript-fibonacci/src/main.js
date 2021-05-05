function fibonacci() {
    var f0 = 0;
    var f1 = 1;
    var sum = f0 + f1;
    var fn;
    for (var index = 0; index < 9; index++) {
        fn = f0 + f1;
        f0 = f1;
        f1 = fn;
        sum += fn;
    }
    console.log("Sum = " + sum);
}
fibonacci();
