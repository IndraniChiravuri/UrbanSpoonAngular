import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {SampleService} from './sample.service';

@Injectable()
export class AuthguardGuard implements CanActivate {
  constructor(private user: SampleService) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    return this.user.getUserLoggedIn();
    //return this.user.getULoggedIn();
   }
}
