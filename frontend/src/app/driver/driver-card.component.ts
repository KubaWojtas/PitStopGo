import {Component, Input} from '@angular/core';

@Component({
  selector: 'swc-driver-card',
  template: `
    <div>
      <p-card class="card" header="{{Name}}" subheader="{{Team}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="../assets/driver/{{Name}}.png"/>
        </ng-template>
      </p-card>
    </div>
  `
})
export class DriverCardComponent {
  @Input()
  Name!: string

  @Input()
  Team!: string
}
