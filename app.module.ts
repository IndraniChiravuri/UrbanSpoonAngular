import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgForm, FormsModule} from '@angular/forms'
import {RouterModule, Routes} from '@angular/router';
import {HttpClient} from '@angular/common/http'
import {AppComponent} from './app.component';
import {AuthguardGuard} from './auth.guard';
import {SigninComponent} from './signin/signin.component';
import {HeadComponent} from './head/head.component';
import {SignupComponent} from './signup/signup.component';
import {UsersignupComponent} from './usersignup/usersignup.component';
import {HttpClientModule} from '@angular/common/http';
import {UsComponent} from './user/us.component';
import {FeedbackComponent} from './feedback/feedback.component';
import {SampleService} from './sample.service';
import {Header2Component} from './header2/header2.component';
import {FlashMessagesModule} from 'angular2-flash-messages';
import {Header1Component} from './header1/header1.component';
import {LogoutComponent} from './logout/logout.component';
import {DishComponent} from './dish/dish.component';
import { SeedishesComponent } from './seedishes/seedishes.component';



const appRoutes: Routes = [
  {path: '', component: HeadComponent},
  {path: 'addDish', component: DishComponent},
   {path: 'seedishes', component: SeedishesComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'home', component: HeadComponent},
  {path : 'userLogin', component : UsComponent},
  {path : 'userRegister', component : UsersignupComponent},
  {path: 'feedback', component: FeedbackComponent},
  {path: 'head/signIn', component: SigninComponent},
  {path: 'head/signUp', component: SignupComponent},
  {path: 'head/userSignUp', component: UsersignupComponent},
  {path: 'header2', component: Header2Component},

];

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    HeadComponent,
    SignupComponent,
    UsersignupComponent,
    UsComponent,
    FeedbackComponent,
    Header2Component,
    Header1Component,
    LogoutComponent,
    DishComponent,
    SeedishesComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
    ), FlashMessagesModule.forRoot()
  ],
  providers: [SampleService, AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule {}
