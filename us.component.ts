import { SampleService } from '../sample.service';
import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';


@Component({
  selector: 'app-us',
  templateUrl: './us.component.html',
  styleUrls: ['./us.component.css']
})
export class UsComponent implements OnInit {
  
  signin = {email: '', password: ''}
  status : boolean;
  msg : number;
  constructor(private http: HttpClient, public user: SampleService, private _flashMessagesService: FlashMessagesService, private router: Router) {}
 /* dishfeedback(data) {

    var body = 'name=' + data.name + '&email=' + data.email + '&rating=' + data.rating + '&comments=' + data.comments ;
    console.log(body);
    this.http.post("project/webresources/api/customer/feedback", body).subscribe(data => console.log(data));
  } */
  ngOnInit() {
  }
  userSignIn(data) {
    console.log("User Login Function");
    var body = 'email=' + data.regname + '&password=' + data.password;
    console.log(body);
    this.http.post("project/webresources/api/customer/usignin", body).toPromise().then(data => {
      console.log(data.toString() + "hgdkjh");
      this.msg=parseInt(data.toString());
      if (!Number.isNaN(Number(this.msg))){
        this.status = true;
        this.user.setUserId(this.msg);
        this.user.setUserLoggedIn();
        this._flashMessagesService.show('Login sucessful', {cssClass: 'alert-success', timeout: 3000});
        this.router.navigate(['./feedback'])
      }
      else {
        this._flashMessagesService.show('Invalid username or password', {cssClass: 'alert-danger', timeout: 3000});
      }
    }).catch(err => {
      console.log(err);
    });
  }
  /*userSignUp(data) {
    console.log("User Sign Up Function");
    this.router.navigate(['./userSignUp'])
  }*/
}
