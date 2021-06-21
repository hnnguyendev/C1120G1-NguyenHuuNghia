import { Component } from '@angular/core';
// @ts-ignore
import {Student} from "../model/Student";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularDirectives';

  public student: Student | undefined;
  public students:Student[] = [
    {name:"Nguyen Van A", gender: 1, point: 100},
    {name:"Nguyen Van B", gender: 0, point: 100},
    {name:"Nguyen Van C", gender: 1, point: 0},
    {name:"Nguyen Van D", gender: 2, point: 60},
  ]

  showDetail(item: Student) {
    this.student = item;
  }


  onGetStudent(value: Student) {
    this.students.unshift(value);
  }
}
