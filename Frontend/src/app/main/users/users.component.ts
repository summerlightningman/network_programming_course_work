import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MainService} from '../../shared/services/main.service';
import {Message} from '@angular/compiler/src/i18n/i18n_ast';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users = [];
  receiver: number;
  interval = null;
  @Output() onChangeDialogue = new EventEmitter<Message[]>();
  @Output() onChangeReceiver = new EventEmitter<number>();

  constructor(private mainService: MainService) {
  }

  ngOnInit() {
    this.mainService.getUsers().subscribe((response) => {
      this.users = response.json();
    });
  }


  openDialogue(receiver: number) {
    clearInterval(this.interval);
    this.interval = setInterval(() => {
      this.receiver = receiver;
      this.mainService.getDialogue(Number(window.localStorage.getItem('id')), receiver).subscribe((response) => {
        this.onChangeDialogue.emit(response.json());
        this.onChangeReceiver.emit(receiver);
      });
    }, 100);
  }

}
