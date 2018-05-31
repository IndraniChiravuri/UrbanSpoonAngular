import { SampleService } from '../sample.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FlashMessagesService} from 'angular2-flash-messages';
@Component({
  selector: 'app-header1',
  templateUrl: './header1.component.html',
  styleUrls: ['./header1.component.css']
})
export class Header1Component implements OnInit {

  constructor(private http: HttpClient, public user: SampleService,private _flashMessagesService: FlashMessagesService,private router:Router) {}
  status:boolean ;
  
  
  ngOnInit() {
     this.http.get("FinalRecipe/webresources/myresource/viewrecipes").subscribe(data => console.log(data));
    //this.status== this.user.getUserLoggedIn();
  }


}
