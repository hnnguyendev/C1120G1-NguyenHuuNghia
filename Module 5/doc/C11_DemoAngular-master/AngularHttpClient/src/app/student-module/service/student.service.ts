import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable(
  // {
  //   providedIn: 'root'
  // }
)
export class StudentService {

  // private _students: Student[] = [
  //   {name: "Nguyen Van A", gender: 1, point: 100},
  //   {name: "VIP", gender: 0, point: 0},
  //   {name: "Nguyen Van A", gender: 1, point: 60},
  //   {name: "VIP", gender: 2, point: 80},
  //   {name: "Nguyen XY", gender: 1, point: 100}
  // ]

  private API_URL = "http://localhost:3000/students";
  constructor(private _httpClient:HttpClient) {
  }

  // get students() {
  //    let promise = this._httpClient.get<Student[]>(this.API_URL).toPromise();
  //    return promise;
  // }

  get students2():Observable<Student[]> {
    return this._httpClient.get<Student[]>(this.API_URL);
  }

  save(student: Student):Observable<Student> {
    // this._students.unshift(student);
    // console.log("save: " + this._students)
    return this._httpClient.post<Student>(this.API_URL, student);
  }


  getStudentByIndex(id: number):Observable<Student> {
    // let id:number = parseInt(String(index)) + 1;
    console.log(id);
    return this._httpClient.get<Student>(`${this.API_URL}/${id}`);
  }
}
