import {Dish} from './dish';
import {Restaurant} from './restaurant';
import {HttpClient} from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import {SampleService} from '../sample.service';
@Component({
  selector: 'app-header2',
  templateUrl: './header2.component.html',
  styleUrls: ['./header2.component.css']
})
export class Header2Component implements OnInit {

  demodata;
  data: Dish[] = [
    {
      dish_id: 1,
      dish_name: "dish1",
      dish_cuisine: "demo1",
      restaurant_id: 12,
      imagePath: ""

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

  constructor(private http: HttpClient, public user: SampleService) {}

  ngOnInit() {
    this.getRestaurants();
    this.getDishes();


  }

  getFeedback() {
    
  }
  getRestaurants() {
    this.http.get<Restaurant[]>("project/webresources/api/customer/getRestaurants")
      .subscribe(data1 => {
        this.demodata1 = data1;
        console.log(this.demodata1);
      });

  }
  getDishes() {
    this.http.get<Dish[]>("project/webresources/api/customer/getDishes/" + this.user.getUserId())
      .subscribe(data => {
        this.demodata = data;
        console.log(this.demodata);

      });
  }
}
