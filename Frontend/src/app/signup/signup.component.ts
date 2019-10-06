import {Component, OnInit} from '@angular/core';
import {MainService} from '../shared/services/main.service';
import {NgForm} from '@angular/forms';
import {RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  file: any;

  fileChange(event) {
    const fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      this.file = fileList[0];
    }
  }

  constructor(private mainService: MainService, private router: Router) {
  }

  ngOnInit() {
  }

  signUp(form: NgForm) {
    if (this.file !== undefined) {
      const formData: FormData = new FormData();
      formData.append('name', this.file.name);
      formData.append('file', this.file, this.file.name);
      this.mainService.upload(formData).subscribe(() =>
        this.mainService.lastImageId().subscribe((response) =>
          this.mainService.register(form.value.nickname, form.value.login, form.value.password, response.json()).subscribe()));
    } else {
      this.mainService.register(form.value.nickname, form.value.login, form.value.password, null);
    }
    this.router.navigate(['/login']);
  }

}
