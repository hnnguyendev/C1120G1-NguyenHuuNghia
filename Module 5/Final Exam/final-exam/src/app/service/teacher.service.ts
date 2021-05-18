import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Teacher } from '../model/Teacher';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  private API_URL = "http://localhost:8080/api/teacher";

  constructor(private _httpClient: HttpClient) { }

  findAll(): Observable<Teacher[]> {
    return this._httpClient.get<Teacher[]>(this.API_URL);
  }
}
