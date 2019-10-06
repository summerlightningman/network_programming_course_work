import {Component, Input, OnInit} from '@angular/core';
import {MainService} from '../../shared/services/main.service';
import {ActivatedRoute} from '@angular/router';
import {Message} from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-dialogue',
  templateUrl: './dialogue.component.html',
  styleUrls: ['./dialogue.component.css']
})

export class DialogueComponent implements OnInit {
  @Input() messages: Message[];
  private id: number;

  constructor(private mainService: MainService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    if (Number(window.localStorage.getItem('id')) !== 0) {
      this.id = Number(window.localStorage.getItem('id'));
    } else {
      this.id = 3;
    }
  }


}
