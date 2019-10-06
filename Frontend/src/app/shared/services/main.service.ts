import {Injectable} from '@angular/core';
import {Http} from '@angular/http';


@Injectable()
export class MainService {
  constructor(private http: Http) {

  }

  getUsers() {
    return this.http.get('http://localhost:8080/user');
  }

  getDialogue(sender: number, receiver: number) {
    return this.http.get('http://localhost:8080/message/dialogue/' + sender + '_' + receiver);
  }

  authorize(login: string, password: string) {
    return this.http.post('http://localhost:8080/user/login', {login: login, password: password});
  }

  register(name: string, login: string, password: string, avatar: string) {
    return this.http.post('http://localhost:8080/user/register', {name: name, login: login, password: password, avatar: avatar});
  }

  upload(body: FormData) {
    return this.http.post('http://localhost:8080/image/upload', body);
  }

  lastImageId() {
    return this.http.get('http://localhost:8080/image/findlast');
  }

  sendImage(receiver: number, text: string) {
    return this.http.post('http://localhost:8080/message/send', {
      sender: window.localStorage.getItem('id'), receiver: receiver,
      time: new Date().toISOString(), text: text
    });
  }
}
