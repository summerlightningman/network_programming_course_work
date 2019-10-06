import {Component, Input, OnInit} from '@angular/core';
import {MainService} from '../shared/services/main.service';
import {Message} from '@angular/compiler/src/i18n/i18n_ast';
import {UsersComponent} from './users/users.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  @Input() receiver: number;
  messages: Message[];

  constructor(private mainService: MainService) {

  }

  ngOnInit() {

  }

  sendMessage(text: HTMLInputElement) {
    this.mainService.sendImage(this.receiver, text.value).subscribe((response) => console.log(response));
    text.value = '';
  }

  updateDialogue(messages: Message[]) {
    this.messages = messages;
  }

  updateReceiver(receiver: number) {
    this.receiver = receiver;
  }
}
