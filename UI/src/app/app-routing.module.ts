import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HubOverviewComponent} from "./hub/hub-overview.component";
import {DriverOverviewComponent} from "./driver/driver-overview.component";
import {TeamOverviewComponent} from "./team/team-overview.component";
import {TrackOverviewComponent} from "./track/track-overview.component";
import {CalendarOverviewComponent} from "./calendar/calender-overview.component";
import {AddDriverFormComponent} from "./calendar/form/add-driver-form.component";
import {CardModule} from "primeng/card";
import {ReactiveFormsModule} from "@angular/forms";
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";

const routes: Routes = [
  {
    path: '',
    component: HubOverviewComponent,
  },
  {
    path: 'drivers',
    component: DriverOverviewComponent,
  },
  {
    path: 'teams',
    component: TeamOverviewComponent,
  },
  {
    path: 'tracks',
    component: TrackOverviewComponent,
  },
  {
    path: 'calendar',
    component: CalendarOverviewComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CardModule, ReactiveFormsModule, InputTextModule, ButtonModule],
    declarations: [
        AddDriverFormComponent
    ],
    exports: [RouterModule, AddDriverFormComponent]
})
export class AppRoutingModule { }
