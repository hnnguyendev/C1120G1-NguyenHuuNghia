import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StudentCreateComponent} from "./student-create/student-create.component";
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentDetailComponent} from "./student-detail/student-detail.component";
import {AppRoutingModule} from "../app-routing.module";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {StudentService} from "./service/student.service";


@NgModule({
  declarations: [
    StudentCreateComponent,
    StudentListComponent,
    StudentDetailComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [StudentService]
})
export class StudentModuleModule { }
