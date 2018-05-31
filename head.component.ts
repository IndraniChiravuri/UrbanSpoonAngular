import {Dish} from '../head/dish';
import { Restaurant } from './restaurant';
import {Component, OnInit, Input} from '@angular/core';
import {FlashMessagesService} from 'angular2-flash-messages';
import {Http} from '@angular/http';
import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit {

  demodata;
  data: Dish[] = [
    {
      dish_id: 1,
      dish_name: "dish1",
      dish_cuisine: "demo1",
      restaurant_id: 12,
      imagePath:""
      
    },
    
  ];
  demodata1;
  data1: Restaurant[] = [
    {
      res_id: 0,
      res_name: "",
      res_pwd: "",
      registration_name: "",
      location: "",
      imagepath: ""
    },
    
  ];

  constructor(private http: HttpClient,private router: Router) {}
  
 
feedback(data){
  console.log("in feedback")
  this.router.navigate(['./userLogin'])
  
  
}
  seeDishes(data){
    this.router.navigate(['./seedishes'])
    
  }
  ngOnInit() {
    this.getRestaurants();
    this.getDishes();
    
    
  }
  getRestaurants(){
    this.http.get<Restaurant[]>("project/webresources/api/customer/getRestaurants")
      .subscribe(data1 => {
        this.demodata1 = data1;
        console.log(this.demodata1);
        });

  }
  getDishes(){
    this.http.get<Dish[]>("project/webresources/api/customer/getDishes")
      .subscribe(data => {
        this.demodata = data;
        console.log(this.demodata);

      });
  }
}
