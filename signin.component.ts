import {SampleService} from '../sample.service';
import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  signin = {email: '', password: ''}

  constructor(private http: HttpClient, public user: SampleService, private _flashMessagesService: FlashMessagesService, private router: Router) {}

  
  status: boolean;
  msg:number;
  
  processsignin(data) {
    var body = 'email=' + data.regname + '&password=' + data.password;
    console.log(body);
    this.http.post("project/webresources/api/customer/signin", body).toPromise().then(data => {
      console.log(data.toString() + "hgdkjh");
      this.msg=parseInt(data.toString());
      if (!Number.isNaN(Number(this.msg))){
        this.status = true;
        this.user.setUserId(this.msg);
        this.user.setUserLoggedIn();
        this._flashMessagesService.show('Login sucessful', {cssClass: 'alert-success', timeout: 3000});
        this.router.navigate(['./header2'])
      }
      else {
        this._flashMessagesService.show('Invalid username or password', {cssClass: 'alert-danger', timeout: 3000});
      }
    }).catch(err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}