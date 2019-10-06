import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {MainService} from '../shared/services/main.service';
import {Router} from '@angular/router';
import {AuthService} from '../shared/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFailed: boolean;

  constructor(private mainService: MainService, private router: Router, private auth: AuthService) {
  }

  ngOnInit() {
  }

  submitForm(form: NgForm) {
    this.mainService.authorize(form.value.login, form.value.password).subscribe((response) => {
      try {
        window.localStorage.setItem('name', response.json().name);
        window.localStorage.setItem('id', response.json().id);
        this.router.navigate(['/']);
        this.auth.logIn();
      } catch (e) {
        this.loginFailed = true;
      }
    });
  }
}
