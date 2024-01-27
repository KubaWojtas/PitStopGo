import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Team} from "../track/model/track.model";

@Component({
  selector: 'swc-team-card',
  template: `
    <div>
      <p-card class="card" header="{{team.name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="../assets/team/{{team.name}}.png"/>
        </ng-template>
        <span>Norris</span>
        <br>
        <span>Norris</span>
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
    console.log(this.team.teamId)
    this.deleteDriver.emit(this.team.teamId)
  }
}
