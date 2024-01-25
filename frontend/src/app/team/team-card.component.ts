import {Component, Input} from '@angular/core';

@Component({
  selector: 'swc-team-card',
  template: `
    <div>
      <p-card class="card" header="{{Name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="../assets/team/{{Name}}.png"/>
        </ng-template>
        <span>Norris</span>
        <br>
        <span>Norris</span>
      </p-card>
    </div>
  `
})
export class TeamCardComponent {
  @Input()
  Name!: string

}
