import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../../service/student.service";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  public student:Student;
  constructor(private _activatedRoute:ActivatedRoute,
              private _studentService:StudentService) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params['id'];
    console.log("ID nhan duoc: " + index);
    this.student = this._studentService.getStudentByIndex(index);
  }

}
