import { Component } from '@angular/core';

@Component({
  selector: 'swc-track-overview',
  template: `
      <div class="flex justify-content-evenly flex-wrap ">
          <swc-track-card
            Name="Brazil"
          ></swc-track-card>
          <swc-track-card
            Name="Singapore"
          ></swc-track-card>
      </div>
  `
})
export class TrackOverviewComponent {
}
