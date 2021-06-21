// function connectDB(x) {
//     setTimeout(function () {
//         console.log("Ket noi DB thanh cong");
//         x();
//     }, Math.floor(Math.random() * 100) + 1)
// }
//
// function selectData(x) {
//     setTimeout(function () {
//         console.log("Select data");
//         x();
//     }, Math.floor(Math.random() * 100) + 1)
// }
//
// function updateData(z) {
//     setTimeout(function () {
//         console.log("Update data");
//         z();
//     }, Math.floor(Math.random() * 100) + 1)
// }
//
//
// function closeConnect() {
//     setTimeout(function () {
//         console.log("Close connect");
//     }, Math.floor(Math.random() * 100) + 1)
// }
//
// connectDB(
//     () => selectData(
//         () => updateData(
//             () => closeConnect()
//         )
//     )
// );
//
//

function connectDB() {
    return new Promise(resolve => {
        setTimeout(function () {
            console.log("Ket noi DB thanh cong");
            resolve();
        }, Math.floor(Math.random() * 100) + 1)
    })

}

function selectData() {
    return new Promise(resolve => {
        setTimeout(function () {
            console.log("Select Data");
            resolve();
        }, Math.floor(Math.random() * 100) + 1)
    })
}

function updateData() {
    return new Promise(reject => {
        setTimeout(function () {
            console.log("Update Data");
            reject("Update loi roi ban");
        }, Math.floor(Math.random() * 100) + 1)
    })
}

function closeDB() {
    return new Promise(resolve => {
        setTimeout(function () {
            console.log("closeDB Data");
            resolve();
        }, Math.floor(Math.random() * 100) + 1)
    })
}

// connectDB()
//     .then(selectData)
//     .then(updateData)
//     .then(closeDB);

async function abc() {
    await connectDB();
    await selectData();
    await updateData().catch((err) => {console.log(err);});
    await closeDB();
}

abc();