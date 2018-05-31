import { Injectable } from '@angular/core';

@Injectable()
export class SampleService {

  private isUserLoggedIn;
  private userid;
  private isULoggedIn;

  constructor() { 
    this.isUserLoggedIn = false;
  }

  setUserLoggedIn() {
    this.isUserLoggedIn = true;
  }

  getUserLoggedIn() {
    return this.isUserLoggedIn;
  }
  setUserId(id:number){
    this.userid=id;
  }
  getUserId():number{
    return this.userid;
  }
  logout(){
     this.isUserLoggedIn = false;
  }
  setULoggedIn() {
    this.isULoggedIn = true;
  }
  getULoggedIn() {
    return this.isULoggedIn;
  }
}
