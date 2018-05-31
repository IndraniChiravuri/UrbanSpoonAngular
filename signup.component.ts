import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
user = {name: '', email:'', password: '', confirmpassword: '', phno:'', regname:'', location:'', img:''};
  
  constructor(private http:HttpClient) {
   }
  processsignup(data){
  var body = 'rname=' + data.rname +  '&password=' + data.password+'&regname=' + data.regname  + '&location=' + data.location+'&img='+data.img;
    console.log(body);
    this.http.post("project/webresources/api/customer/res/signup",body).subscribe(data => console.log(data));
  }

  ngOnInit() {
  }

}