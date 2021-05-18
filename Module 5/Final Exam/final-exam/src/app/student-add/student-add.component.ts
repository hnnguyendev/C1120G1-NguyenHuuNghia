import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Teacher } from '../model/Teacher';
import { StudentService } from '../service/student.service';
import { TeacherService } from '../service/teacher.service';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.scss']
})
export class StudentAddComponent implements OnInit {

  refStudent: FormGroup;
  teachers: Teacher[] = [];

  constructor(private _formBuilder: FormBuilder,
    private _studentService: StudentService,
    private _teacherService: TeacherService,
    private _router: Router) { }

  ngOnInit(): void {
    this._teacherService.findAll().subscribe(data => {
      this.teachers = data;
      console.log(this.teachers);
    });

    this.formInit();
  }

  formInit() {
    this.refStudent = this._formBuilder.group({
      name: ["", [Validators.required, Validators.pattern("^[A-Z][a-z]+(\\s[A-Z]([a-z]+)|(\\s[A-Z]))*$")]],
      team: ["", [Validators.required]],
      topic: ["", [Validators.required]],
      teacher: ["", [Validators.required]],
      email: ["", [Validators.required, Validators.email]],
      phone: ["", [Validators.required, Validators.pattern("^\\d{10,12}$")]]
    });

  }

  submitForm() {
    if (this.refStudent.valid) {
      this._studentService.save(this.refStudent.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      }, error => {
        console.log("error");
      })
    }
  }

}
