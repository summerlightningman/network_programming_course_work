import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {SignupComponent} from './signup/signup.component';
import {AppRoutingModule} from './app-routing.module';
import {AboutComponent} from './about/about.component';
import {MainService} from './shared/services/main.service';
import {UsersComponent} from './main/users/users.component';
import {DialogueComponent} from './main/dialogue/dialogue.component';
import {AuthService} from './shared/services/auth.service';
import {AuthGuard} from './shared/services/auth-guard.service';


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    LoginComponent,
    SignupComponent,
    AboutComponent,
    UsersComponent,
    DialogueComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [MainService, AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
