import { SampleService } from '../sample.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlashMessagesService } from 'angular2-flash-messages';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private http:HttpClient, public user: SampleService,private _flashMessagesService: FlashMessagesService,private router:Router) { }

  ngOnInit() {
    this.user.logout();
    this.router.navigate(['./home'])
  }

}
