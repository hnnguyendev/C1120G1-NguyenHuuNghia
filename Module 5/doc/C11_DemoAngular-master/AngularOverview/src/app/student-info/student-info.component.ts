import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Student} from "../model/Student";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit, OnChanges {

  public student: Student = new Student(2, "Hong", 50);

  public isDisable: boolean = true;

  public title: string = "Student info CP";

  public color: string = "black";

  constructor() {
  }

  ngOnInit(): void {
    if (this.student.point < 100) {
      this.isDisable = false;
    }
  }


  updatePoint(value: string) {
    this.student.point = parseInt(value);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log(this.student.point);
  }


  update(value: string) {
    if (value == "red") {
      this.color = "red";
    } else {
      this.color = "black";
    }
  }
}
