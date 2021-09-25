import { Component } from '@angular/core';
import {AdminServiceService} from './admin-service.service'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AdminAngular';

  temp : any= [] ;
   
  check = false;
  constructor (private admin:AdminServiceService){
      this.admin.getData().subscribe(data=>{
         this.temp=data
      })
  }
  
  onClickSubmit(data: any){
    for(let i=0; i<this.temp.length; i++){
      if(data.adminName==this.temp[0].adminName && data.passwd==this.temp[0].adminPassword){
        console.log("You have successfully login");
        this.check=true;
      }
     
    }
  }



}
