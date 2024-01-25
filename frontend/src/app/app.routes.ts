import { Routes } from '@angular/router';
import {HubOverviewComponent} from "./hub/hub-overview.component";
import {DriverOverviewComponent} from "./driver/driver-overview.component";
import {TeamOverviewComponent} from "./team/team-overview.component";
import {TrackOverviewComponent} from "./track/track-overview.component";

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
    path: 'calender',
    component: DriverOverviewComponent,
  }
];
export default routes;
