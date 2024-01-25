import { Component } from '@angular/core';

@Component({
  selector: 'swc-team-overview',
  template: `
      <div class="flex justify-content-evenly flex-wrap ">
          <swc-team-card
            Name="McLaren"
          ></swc-team-card>
          <swc-team-card
            Name="Mercedes"
          ></swc-team-card>
      </div>
  `
})
export class TeamOverviewComponent {
}
