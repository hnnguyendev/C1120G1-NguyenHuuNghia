import { Component, OnInit } from '@angular/core';
import { Student } from '../model/Student';
import { DialogService } from '../service/dialog.service';
import { StudentService } from '../service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss']
})
export class StudentListComponent implements OnInit {

  // students: Student[] = [];
  students;
  txtSearch: string;

  constructor(private _studentService: StudentService,
    private _dialogService: DialogService) { }

  ngOnInit(): void {
    // this._studentService.findAll().subscribe(data => {
    //   this.students = data;
    // }, error => {
    //   console.log(error);
    // });
    this.onList(0);
  }

  onList(pageable: number) {
    this._studentService.findAll(pageable).subscribe(data => {
      this.students = data;
    }, error => {
      console.log(error);
    });
  }

  onDelete(id: number): void {
    this._dialogService.openDialog(id).afterClosed().subscribe(result => {
      if (result) {
        this._studentService.delete(id).subscribe(() => {
          this.ngOnInit();
        });
      }
    });
  }

  onSearch() {
    this._studentService.search(this.txtSearch).subscribe(data => {
      this.students = data;
    });
  }

}
