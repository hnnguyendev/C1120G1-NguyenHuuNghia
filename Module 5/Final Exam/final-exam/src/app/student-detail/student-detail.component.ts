import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../model/Student';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.scss']
})
export class StudentDetailComponent implements OnInit {

  student: Student;

  constructor(private _studentService: StudentService,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.params["id"];
    this._studentService.findById(id).subscribe(data => {
      this.student = data;
    })
  }

}
