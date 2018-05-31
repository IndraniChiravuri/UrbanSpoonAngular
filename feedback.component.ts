import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {FlashMessagesService} from 'angular2-flash-messages';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  feedback = {name: '', email: '', rating: ''}

  constructor(private http: HttpClient, private _flashMessagesService: FlashMessagesService) {}
  dishfeedback(data) {

    var body = 'name=' + data.name + '&email=' + data.email + '&rating=' + data.rating + '&comments=' + data.comments ;
    console.log(body);
    this.http.post("project/webresources/api/customer/feedback", body).subscribe(data => console.log(data));
  }  ngOnInit() {
  }

}
