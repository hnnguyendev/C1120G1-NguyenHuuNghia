function isPalindrome(str) {
    let first = 0;
    let last = str.length - 1;
    let check = true;
    for (let i = 0; i < str.length / 2; i++) {
        if (str[first] !== str[last]) {
            check = false;
            break;
        }
        first++;
        last--;
    }
    if (check) {
        return true;
    }
    return false;
}

function isSquareNumber(number) {
    let numberCheck = Math.sqrt(number);
    if (Number.parseInt(numberCheck) === numberCheck) {
        return true;
    }
    return false;
}

function isPerfectNumber(number) {
    let sum = 0;
    for (let i = 1; i < number; i++) {
        if (number % i === 0) {
            sum += i;
        }
    }
    if (sum === number) {
        return true;
    }
    return false;
}

function isLeapYear(year) {
    if ((year % 4 === 0 && year % 100 != 0) || year % 400 === 0) {
        return true;
    }
    return false;
}

function isPrime(number) {
    let count = 0;
    for (let index = 1; index <= Math.sqrt(number); index++) {
        if (number % index === 0) {
            count++;
        }
    }
    if (count === 1) {
        return true;
    }
    return false;

    // cach lam nay toi uu hon cach tren
    // let flag = true;
    // if (number < 2) {
    //     flag = false;
    // }
    // if (number === 2) {
    //     flag = true;
    // }
    // for (let index = 2; index <= Math.sqrt(number); index++) {
    //     if (number % index === 0) {
    //         flag = false;
    //         break;
    //     }
    // }

    if (flag) {
        return true;
    }
    return false
}

// for (let index2 = 2; index2 < 10000; index2++) {
//     if (isPrime(index2)) {
//         document.write(index2 + " ");
//     }
// }

// function fibonachi() {
//     let f0 = 0;
//     let f1 = 1;
//     let sum = f0 + f1;
//     let fn;
//     for (let index = 0; index < 18; index++) {
//         fn = f0 + f1;
//         f0 = f1;
//         f1 = fn;
//         sum += fn;
//     }
//     document.write("Sum = " + sum);
// }

function bubbleSort(arr) {
    const len = arr.length;
    for (let i = len-1; i >= 0; i--) {
        for (let j = 1; j <= i; j++) {
            if (arr[j-1] > arr[j]) {
                let temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

function selectionSort(arr) {
    let minIndex, temp,
        len = arr.length;

    for (let i = 0; i < len; i++) {
        minIndex = i;
        // tìm index của giá trị nhỏ nhất
        for (let  j = i+1; j < len; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        // Đổi chỗ
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}