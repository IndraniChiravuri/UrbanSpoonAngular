import { Dish } from '../head/dish';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-seedishes',
  templateUrl: './seedishes.component.html',
  styleUrls: ['./seedishes.component.css']
})
export class SeedishesComponent implements OnInit {
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
  res_id;
  sub:any;
  constructor(private http: HttpClient,private router: Router,private route:ActivatedRoute) { }
    ngOnInit() {
    this.sub=this.route.params.subscribe(params => {
    this.res_id=params['rest_id'];
    console.log(this.res_id);
    this.http.get<Dish[]>("project/webresources/api/customer/getDishes/1")
      .subscribe(data => {
        this.demodata = data;
        console.log(this.demodata);

      });
  
    });
    
  
  }

}
