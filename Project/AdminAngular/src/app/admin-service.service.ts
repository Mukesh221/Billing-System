import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  constructor(private http:HttpClient) { }

  getData(){
    let url = "http://localhost:4000/admin";
    return this.http.get(url);
  }

  getMonthData(){
    let url = "http://localhost:4000/bill";
    return this.http.get(url);
  }

   
}
