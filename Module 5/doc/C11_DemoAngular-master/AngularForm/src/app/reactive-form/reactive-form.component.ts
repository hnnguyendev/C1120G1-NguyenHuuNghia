import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  rfStudent: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }


  ngOnInit(): void {

    /*Su dung formBuilder*/
    // this.rfStudent = this._formBuilder.group({
    //   studentName: ['Anh', [Validators.required]],
    //   studentGender: [''],
    //   studentPoint: [50]
    // })

    /*su dung FormGroup */
    this.rfStudent = new FormGroup({
      studentName: new FormControl("Ho"),
      studentGender: new FormControl(),
      studentPoint: new FormControl()
    })
  }

  onSubmit() {
    console.log(this.rfStudent.value)
  }
}
