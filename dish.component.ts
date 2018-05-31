import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.css']
})
export class DishComponent implements OnInit {
constructor(private http: HttpClient) {}
  addDish(data) {

    var body = 'uname=' + data.dname + '&cuisine=' + data.cuisine + '&img=' + data.img;
    console.log(body);
    this.http.post("project/webresources/api/customer/addDish", body).subscribe(data => console.log(data));
  }

  ngOnInit() {
  }

}
