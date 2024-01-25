import { Component } from '@angular/core';

@Component({
  selector: 'swc-nav',
  template: `
      <div class="flex justify-content-evenly flex-wrap py-5">
          <p-button [routerLink]="['/']">Hub</p-button>
          <p-button [routerLink]="['/drivers']">Drivers</p-button>
          <p-button [routerLink]="['/teams']">Teams</p-button>
          <p-button [routerLink]="['/tracks']">Tracks</p-button>
          <p-button [routerLink]="['/calender']">Calender</p-button>
      </div>
  `
})
export class NavComponent {
}
