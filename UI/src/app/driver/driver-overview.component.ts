import {Component, OnInit} from '@angular/core';
import {Driver} from "./model/driver.model";
import {DriverService} from "../service/driver.service";
import {TeamService} from "../service/team.service";
import {Track} from "../track/model/track.model";
import {Team} from "../team/model/team.model";

@Component({
  selector: 'swc-driver-overview',
  template: `
    <p-button type="button" class="mr-2" (click)="sidebarVisible = true" icon="pi pi-arrow-left"></p-button>
    <p-sidebar [(visible)]="sidebarVisible" position="right">
      <H1>Add Driver</H1>
      <swc-add-driver-form (driverForm)="addDriver($event)"></swc-add-driver-form>
    </p-sidebar>
    <div class="flex justify-content-evenly flex-wrap ">
      <swc-driver-card *ngFor="let driver of drivers"
                       [driver]="driver"
                       (deleteDriver)="deleteDriver($event)"
                       [team]="getDriverTeam(driver)"
      ></swc-driver-card>
    </div>
  `
})
export class DriverOverviewComponent implements OnInit {

  drivers: Driver[] = [];
  teams: Team[] = [];

  sidebarVisible: boolean = false;

  constructor(private service: DriverService,
              private teamService: TeamService) {
  }

  ngOnInit() {
    this.retrieveDrivers();
    this.getTeams();
  }

  retrieveDrivers() {
    this.service.getAll()
      .subscribe(
        data => {
          this.drivers = data
          console.log(data)
        }
      )
  }

  addDriver(data: any) {
    console.log(data)
    this.service.create(data)
      .subscribe(() => {
        this.ngOnInit();
        this.sidebarVisible = false;
      });
  }

  deleteDriver(data: any) {
    console.log(data)
    this.service.delete(data)
      .subscribe(() => this.ngOnInit())
  }


  getTeams() {
    this.teamService.getAll()
      .subscribe(data => {
        this.teams = data;
        console.log(data)
      })
  }

  getDriverTeam(driver : Driver) {
    let t;
    for (let team of this.teams) {
      if (driver.teamId == team.teamId!.toString()) {
        t = team;
      }
    }
    return t!
  }
}
