import {NgModule} from '@angular/core';
import {AppComponent} from "./app.component";
import {HubOverviewComponent} from "./hub/hub-overview.component";
import {ButtonModule} from "primeng/button";
import {DriverOverviewComponent} from "./driver/driver-overview.component";
import {CardModule} from "primeng/card";
import {DriverCardComponent} from "./driver/driver-card.component";
import {CommonModule, NgClass, NgForOf, NgIf} from "@angular/common";
import {TabViewModule} from "primeng/tabview";
import {RouterLink} from "@angular/router";
import {NavComponent} from "./nav/nav.component";
import {TeamOverviewComponent} from "./team/team-overview.component";
import {TeamCardComponent} from "./team/team-card.component";
import {TrackOverviewComponent} from "./track/track-overview.component";
import {TrackCardComponent} from "./track/track-card.component";
import {HttpClientModule} from "@angular/common/http";
import {AddDriverFormComponent} from "./driver/form/add-driver-form.component";
import {DialogModule} from "primeng/dialog";
import {SidebarModule} from "primeng/sidebar";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ChipsModule} from "primeng/chips";
import {AddTeamFormComponent} from "./team/form/add-team-form.component";
import {AddTrackFormComponent} from "./track/form/add-track-form.component";

@NgModule({
    declarations: [
        NavComponent,
        HubOverviewComponent,
        DriverOverviewComponent,
        DriverCardComponent,
        TeamOverviewComponent,
        TeamCardComponent,
        TrackOverviewComponent,
        TrackCardComponent,
        AddDriverFormComponent,
        AddTeamFormComponent,
        AddTrackFormComponent
    ],
    imports: [
        AppComponent,
        RouterLink,
        ButtonModule,
        CardModule,
        NgClass,
        TabViewModule,
        RouterLink,
        NgForOf,
        HttpClientModule,
        DialogModule,
        SidebarModule,
        FormsModule,
        ChipsModule,
        ReactiveFormsModule,
        NgIf,
    ],
    providers: [],
    exports: [
        HubOverviewComponent,
        DriverOverviewComponent,
        NavComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
