import { Component } from '@angular/core';
import {Student} from "../model/Student";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularDirectives';

  public students:Student[] = [
    new Student("Nguyen Van A", 0, 100),
    new Student("VIP", 1, 0),
    new Student("Nguyen Van C", 2, 60),
    new Student("VIP", 2, 60)
  ]
}
