import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Track} from "./model/track.model";

@Component({
  selector: 'swc-track-card',
  template: `
    <div>
      <p-card class="card" header="{{track.name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="https://primefaces.org/cdn/primeng/images/usercard.png" />
        </ng-template>
        <p-button label="Delete" (onClick)="delete()"></p-button>
      </p-card>
    </div>
  `
})
export class TrackCardComponent {
  @Input()
  track!: Track

  @Output()
  deleteTrack = new EventEmitter<any>();

  delete() {
    console.log(this.track.trackId)
    this.deleteTrack.emit(this.track.trackId)
  }
}
