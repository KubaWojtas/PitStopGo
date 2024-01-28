import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Driver} from "./model/driver.model";

@Component({
  selector: 'swc-driver-card',
  template: `
    <div>
      <p-card class="card" header="{{driver.name}}" subheader="{{driver.team}}" [style]="{ width: '285px' }">
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

  @Output()
  deleteDriver = new EventEmitter<any>();

  delete() {
    console.log(this.driver.driverId)
    this.deleteDriver.emit(this.driver.driverId)
  }

}
