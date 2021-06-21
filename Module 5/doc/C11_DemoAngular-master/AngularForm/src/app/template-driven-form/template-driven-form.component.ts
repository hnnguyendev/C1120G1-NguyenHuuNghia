import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  public student:Student = {name: "", gender: 0, point: 0};
  constructor() { }

  ngOnInit(): void {
  }

  onSubmitForm(studentForm: NgForm) {
    if(studentForm.valid){
      console.log(this.student)
    }

  }

  onResetForm(studentForm: NgForm) {
    studentForm.reset();
  }
}
