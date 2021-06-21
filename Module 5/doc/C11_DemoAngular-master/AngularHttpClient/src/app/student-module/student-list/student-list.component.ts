import {Component, OnInit} from '@angular/core';
import {StudentService} from "../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  // providers: [StudentService]
})
export class StudentListComponent implements OnInit {

  public studentList: Student[] = [];

  constructor(private _studentService: StudentService,
              private _router: Router) {
  }

  public title = "abc";

  ngOnInit(): void {
    // this._studentService.students.then((data) => {
    //   console.log(data);
    //   this.studentList = data;
    // }).catch((error) => {
    //   console.log(error);
    // });
    this._studentService.students2.subscribe((data) => {
      this.studentList = data;
      this.title = "co " + this.studentList.length + " sinh vien";
    }, error => {
      console.log(error);
    }, ()=> {

    })



  }


  showDetail(index: number) {
    console.log("Index to Detail: " + index);
    this._router.navigate(["/detail", index]);
  }

  // get studentList(): Student[] {
  //   return this._studentList;
  // }
}
