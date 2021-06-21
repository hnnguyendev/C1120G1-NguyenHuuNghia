var connectDB = function (user, pass) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            if (user != "admin" || pass != "123") {
                return reject("tai khoan hoac pass khong hop le");
            }
            else {
                return resolve("Ket noi OK");
            }
        }, 5000);
    });
};
connectDB("admin", "1234")
    .then(function (data) { return console.log("OK: " + data); })["catch"](function (err) { return console.log("NG: " + err); });
// setTimeout( function () {
//     console.log("day la a");
// }, 5000)
// console.log("day la b");
