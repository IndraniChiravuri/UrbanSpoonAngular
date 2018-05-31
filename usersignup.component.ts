import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-usersignup',
  templateUrl: './usersignup.component.html',
  styleUrls: ['./usersignup.component.css']
})
export class UsersignupComponent implements OnInit {

  constructor(private http:HttpClient) { }
  
  userSignUp(data){
  var body = 'uname=' + data.uname + '&email=' + data.email + '&password=' + data.password + '&phno=' + data.phno;
    console.log(body);
    this.http.post("project/webresources/api/customer/signup",body).subscribe(data => console.log(data));
  }

  ngOnInit() {
  }

}