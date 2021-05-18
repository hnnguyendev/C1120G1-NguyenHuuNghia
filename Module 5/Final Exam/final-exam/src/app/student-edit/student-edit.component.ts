import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from '../model/Teacher';
import { StudentService } from '../service/student.service';
import { TeacherService } from '../service/teacher.service';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.scss']
})
export class StudentEditComponent implements OnInit {

  refStudent: FormGroup;
  id: number;
  teachers: Teacher[] = [];

  constructor(private _formBuilder: FormBuilder,
    private _studentService: StudentService,
    private _teacherService: TeacherService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._teacherService.findAll().subscribe(data => {
      this.teachers = data;
      console.log(this.teachers);
    });

    this.formInit();

    this.id = this._activatedRoute.snapshot.params["id"];
    console.log(this.id);
    this._studentService.findById(this.id).subscribe(oldData => {
      this.refStudent.setValue(oldData);

      console.log(this.refStudent.value);
    });
  }

  formInit() {
    this.refStudent = this._formBuilder.group({
      id: [""],
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
        console.log(error);
      })
    }
  }

  compareObjects(o1: any, o2: any): boolean {
    return o1.name === o2.name && o1._id === o2._id;
  }

}
