import {Injectable} from '@angular/core';

@Injectable(
  {
    providedIn: 'root'
  }
)
export class StudentService {

  private _students: Student[] = [
    {name: "Nguyen Van A", gender: 1, point: 100},
    {name: "VIP", gender: 0, point: 0},
    {name: "Nguyen Van A", gender: 1, point: 60},
    {name: "VIP", gender: 2, point: 80},
    {name: "Nguyen XY", gender: 1, point: 100}
  ]

  constructor() {
  }


  get students(): Student[] {
    return this._students;
  }

  save(student: Student) {
    this._students.unshift(student);
    console.log("save: " + this._students)
  }


  getStudentByIndex(index: number) {
    return this._students[index];
  }
}
