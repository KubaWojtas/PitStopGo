import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavComponent} from "./nav/nav.component";
import {ButtonModule} from "primeng/button";
import {HubOverviewComponent} from "./hub/hub-overview.component";
import {DriverOverviewComponent} from "./driver/driver-overview.component";
import {DriverCardComponent} from "./driver/driver-card.component";
import {AddDriverFormComponent} from "./driver/form/add-driver-form.component";
import {CardModule} from "primeng/card";
import {ReactiveFormsModule} from "@angular/forms";
import {ChipsModule} from "primeng/chips";
import {TeamOverviewComponent} from "./team/team-overview.component";
import {TeamCardComponent} from "./team/team-card.component";
import {AddTeamFormComponent} from "./team/form/add-team-form.component";
import {TrackOverviewComponent} from "./track/track-overview.component";
import {TrackCardComponent} from "./track/track-card.component";
import {AddTrackFormComponent} from "./track/form/add-track-form.component";
import {SidebarModule} from "primeng/sidebar";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {DriverService} from "./service/driver.service";
import {TeamService} from "./service/team.service";
import {TrackService} from "./service/track.service";

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,

    //Hub
    HubOverviewComponent,

    //Driver
    DriverOverviewComponent,
    DriverCardComponent,
    AddDriverFormComponent,

    //Team
    TeamOverviewComponent,
    TeamCardComponent,
    AddTeamFormComponent,

    //Track
    TrackOverviewComponent,
    TrackCardComponent,
    AddTrackFormComponent,

    //Calendar
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    ButtonModule,
    CardModule,
    ReactiveFormsModule,
    ChipsModule,
    SidebarModule,
  ],
  providers: [
    HttpClient,
    DriverService,
    TeamService,
    TrackService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
