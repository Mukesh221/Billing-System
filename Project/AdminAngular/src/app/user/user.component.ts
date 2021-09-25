import { Component, OnInit, Input } from '@angular/core';
import {AdminServiceService} from '../admin-service.service'
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  
  @Input() check : any

  getName(){
    this.check=false;
  }

  today : any = new Date();
  dd : any = this.today.getDate();
  mm : any = '0' + (new Date().getMonth() + 1).toString().slice(-2);

  temp : any= [] ;
  temp1 : any= [] ;
  t = 0;
  
  constructor(private admin:AdminServiceService) { 
    this.admin.getMonthData().subscribe(data=>{
    this.temp=data


    for(let i = 0; i<this.temp.length; i++){
      let f = this.temp[i].billDate 
       
       
      let g = f[5]+f[6]
      if(g==this.mm){
        this.t= this.t+this.temp[i].totalAmount
         
      }

      let h = f[8]+f[9];
      console.warn(this.dd);
      if(h==this.dd){
         this.temp1.push(this.temp[i]);
         
      }
     
      }
    })
    
    this.admin.getMonthData().subscribe(data=>{
      
      //console.warn(data);
    })

  }
  ngOnInit(): void {
  }

   
}
