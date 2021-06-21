// happy coding 👻
console.log("hello world");
var className = "C1120G1";
var number = 5;
var Gender;
(function (Gender) {
    Gender[Gender["MALE"] = 8] = "MALE";
    Gender[Gender["FEMALE"] = 9] = "FEMALE";
    Gender[Gender["OTHER"] = 10] = "OTHER";
})(Gender || (Gender = {}));
;
var myGender = Gender.MALE;
console.log(myGender);
console.log(Gender[9]); // 8 9 10
var count;
count = 5;
count = true;
var myArray = new Array(8);
var myArray1 = ["1", "2"];
var myArray3 = [1, 2, 3, 4];
var map = myArray3.map(function (x) { return x; });
console.log("Map: " + map);
var abc = myArray3.forEach(function (x) { return console.log(x); });
var xyz = myArray3.filter(function (x) {
    return x % 2 == 0;
});
console.log("Filter: " + xyz);
