import {Component, Input} from '@angular/core';

@Component({
  selector: 'swc-track-card',
  template: `
    <div>
      <p-card class="card" header="{{Name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="../assets/track/{{Name}}.png"/>
        </ng-template>
      </p-card>
    </div>
  `
})
export class TrackCardComponent {
  @Input()
  Name!: string
}
