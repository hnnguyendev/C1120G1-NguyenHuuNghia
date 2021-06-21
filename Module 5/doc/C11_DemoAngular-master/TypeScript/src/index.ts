// happy coding 👻
import {Student} from "./Student";

console.log("hello world");

const className:string = "C1120G1";
let number:number = 5;

enum Gender {MALE= 8, FEMALE, OTHER};
var myGender:Gender = Gender.MALE;

console.log(myGender);
console.log(Gender[9]); // 8 9 10

var count:any;
count = 5;
count = true;

var myArray:number[] = new Array(8);
var myArray1:string[] = ["1","2"];
var myArray3:Array<number> = [1,2,3,4];

let map = myArray3.map(x => x);
console.log("Map: " +map)

let abc = myArray3.forEach(x => console.log(x));

let xyz = myArray3.filter(x =>{
    return x%2 ==0;

});
console.log("Filter: "+xyz);

var myTuple1:[string, number,number?];
myTuple1 = ["Hue", 8, 9];
myTuple1 = ["Tung", 8];
// myTuple1 = [9, "Hue"];

let student:Student = new Student(1,"Hoang",10);
console.log(student.showInfo())

