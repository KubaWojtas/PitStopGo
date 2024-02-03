import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Driver} from "./model/driver.model";
import {TeamService} from "../service/team.service";
import {Track} from "../track/model/track.model";

@Component({
  selector: 'swc-driver-card',
  template: `
    <div>
      <p-card class="card" header="{{driver.firstName}} {{driver.lastName}}" subheader="{{team.name}}" [style]="{ width: '285px' }">
        <ng-template pTemplate="header" class="card-img-top">
          <img alt="Card" src="https://primefaces.org/cdn/primeng/images/usercard.png" />
        </ng-template>
        <p-button label="Delete" (onClick)="delete()"></p-button>
      </p-card>
    </div>
  `
})
export class DriverCardComponent {
  @Input()
  driver!: Driver;
  @Input()
  team!: Track;

  @Output()
  deleteDriver = new EventEmitter<any>();

  delete() {
    this.deleteDriver.emit(this.driver.driverId)
  }

}
