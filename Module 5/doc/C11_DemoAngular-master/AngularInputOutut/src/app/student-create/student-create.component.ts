import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../../model/Student";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  @Output('studentCreate') onCreate = new EventEmitter<Student>();

  constructor() { }
  public student: Student | undefined;

  ngOnInit(): void {
  }

  create(name:string, gender: string, point: string){
    this.student = new Student(name, parseInt(gender), parseInt(point));
    console.log(this.student);
    this.onCreate.emit(this.student);
  }
}
