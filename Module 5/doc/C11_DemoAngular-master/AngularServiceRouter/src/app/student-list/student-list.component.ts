import {Component, OnInit} from '@angular/core';
import {StudentService} from "../../service/student.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  providers: [StudentService]
})
export class StudentListComponent implements OnInit {

  public studentList:Student[] = [];

  constructor(private _studentService: StudentService,
              private _router:Router) {
  }

  ngOnInit(): void {
    this.studentList = this._studentService.students;
  }


  showDetail(index: number) {
    console.log("Index to Detail: "+ index);
    this._router.navigate(["/detail",index]);
  }

  // get studentList(): Student[] {
  //   return this._studentList;
  // }
}
