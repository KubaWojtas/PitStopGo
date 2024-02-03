import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Track} from "../track/model/track.model";
import {Team} from "./model/team.model";

@Component({
  selector: 'swc-team-card',
  template: `
    <div>
      <p-card class="card" header="{{team.name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="https://primefaces.org/cdn/primeng/images/usercard.png" />
        </ng-template>
        <div *ngFor="let driver of team.drivers">
          <span>{{driver}}</span>
          <br>
        </div>
        <p-button label="Delete" (onClick)="delete()"></p-button>
      </p-card>
    </div>
  `
})
export class TeamCardComponent {
  @Input()
  team!: Team;

  @Output()
  deleteDriver = new EventEmitter<any>();

  delete() {
    this.deleteDriver.emit(this.team.teamId)
  }
}
