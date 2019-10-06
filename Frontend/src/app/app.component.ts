import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from './shared/services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app works!';

  constructor(private router: Router, private auth: AuthService) {

  }

  ngOnInit(): void {
    this.auth.isLoggedIn = Number(window.localStorage.getItem('id')) !== 0;
  }

  logOut() {
    this.router.navigate(['/login']);
    this.auth.logOut();
  }

}
