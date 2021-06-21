import {Component, OnInit} from '@angular/core';
// @ts-ignore
import {Student} from "./student-module/model/Student";
import {StudentService} from "./student-module/service/student.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'AngularDirectives';

}
