import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css'],
  // providers: [StudentService]
})
export class StudentCreateComponent implements OnInit {
  // @ts-ignore
  rfStudent: FormGroup;

  constructor(private _formBuilder: FormBuilder,
              private _studentService: StudentService,
              private _router: Router) {
  }

  ngOnInit(): void {
    /*su dung FormGroup*/
    // this.rfStudent = new FormGroup({
    //   studentName: new FormControl("Anh"),
    //   studentGender: new FormControl(1),
    //   studentPoint: new FormControl(100),
    // },);

    /*su dung formBuilder*/
    this.rfStudent = this._formBuilder.group({
      name: ['Anh', [Validators.required, Validators.minLength(5)]],
      gender: [''],
      point: [50]
    })
  }

  onSubmit() {
    // Do something awesome
    console.log(this.rfStudent.value);
    if (this.rfStudent.valid) {
      this._studentService.save(this.rfStudent.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      }, error => {
        console.log("Error");
      });

    }
  }

  onResetStu() {
    this.rfStudent.reset();
  }

}
