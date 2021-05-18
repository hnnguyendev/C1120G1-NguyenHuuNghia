import { AbstractControl } from "@angular/forms";

function getAge(birthDateString) {
    var today = new Date();
    var birthDate = new Date(birthDateString);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}

export function validateBeforeCurrentDate(control: AbstractControl) {
    let currentDate = new Date();
    let inputDate = new Date(control.value)
    if (inputDate > currentDate || getAge(inputDate) <= 18) {
        return { beforeCurrentDate: true };
    }
    return false;
}