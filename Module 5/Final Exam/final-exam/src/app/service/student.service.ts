import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private API_URL = "http://localhost:8080/api/student";

  constructor(private _httpClient: HttpClient) { }

  // findAll(): Observable<Student[]> {
  //   return this._httpClient.get<Student[]>(this.API_URL);
  // }

  findAll(page: number): Observable<Student[]> {
    return this._httpClient.get<Student[]>(`${this.API_URL}?page=${page}`);
  }

  save(student: Student): Observable<Student> {
    return this._httpClient.post<Student>(this.API_URL, student);
  }

  findById(id: number): Observable<Student> {
    return this._httpClient.get<Student>(`${this.API_URL}/${id}`);
  }

  delete(id: number): Observable<Student> {
    return this._httpClient.delete<Student>(`${this.API_URL}/${id}`);
  }

  search(txtSearch: string): Observable<Student[]> {
    return this._httpClient.get<Student[]>(`${this.API_URL}?txtSearch=${txtSearch}`);
  }
}
