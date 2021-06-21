import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {StudentCreateComponent} from './student-create/student-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import {StudentListComponent} from './student-list/student-list.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentService} from "../service/student.service";

@NgModule({
  declarations: [
    AppComponent,
    StudentCreateComponent,
    StudentListComponent,
    StudentDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
