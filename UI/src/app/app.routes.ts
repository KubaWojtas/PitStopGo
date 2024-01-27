import { Routes } from '@angular/router';
import {HubOverviewComponent} from "../../../UI/src/app/hub/hub-overview.component";
import {DriverOverviewComponent} from "../../../UI/src/app/driver/driver-overview.component";
import {TeamOverviewComponent} from "../../../UI/src/app/team/team-overview.component";
import {TrackOverviewComponent} from "../../../UI/src/app/track/track-overview.component";

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
    component: HubOverviewComponent,
  }
];
export default routes;
