import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../models/employee';
import { FullDetail } from '../models/fullDetail';

@Injectable({
  providedIn: 'root'
})
export class DataService {
 

  variableUrl!: string;
  variableDetailUrl!: string;
  
  public setTest(value: string) {
    this.variableUrl = value;
  }

  public setDetailTest(value: string) {
    this.variableDetailUrl = value;
  }
  

  constructor(private http: HttpClient) { }

  
  

  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.variableUrl);
  }
  
  getFullDetail(): Observable<FullDetail[]>{
    return this.http.get<FullDetail[]>(this.variableDetailUrl);
  }
  

}
