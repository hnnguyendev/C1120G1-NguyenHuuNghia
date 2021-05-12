import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  rfRegister: FormGroup;

  countryList: string[] = ["Viet", "Cam", "Laos"];

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.formInit();
  }

  formInit() {
    this.rfRegister = this._formBuilder.group({
      email: ["", [Validators.email, Validators.required]],
      password: ["", [Validators.required, Validators.minLength(6)]],
      confirmPassword: [""],
      country: ["Viet", [Validators.required]],
      age: ["", [Validators.required, Validators.min(19)]],
      gender: ["", [Validators.required]],
      phone: ["", [Validators.required, Validators.pattern("^\\+84\\d{9,10}$")]],
    });
  }

  submitForm() {
    if (this.rfRegister.valid) {
      alert("Uy tin luon! " + this.rfRegister.value.email);
    }
  }

}
