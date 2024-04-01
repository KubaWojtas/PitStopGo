import {Component, OnInit} from '@angular/core';
import {Driver} from "../driver/model/driver.model";
import {Team} from "../team/model/team.model";
import {DriverService} from "../service/driver.service";
import {TeamService} from "../service/team.service";
import {CalendarService} from "../service/calendar.service";
import {RaceService} from "../service/race.service";
import {Calendar} from "./model/calendar.model";
import {Race} from "./race/race.model";

@Component({
  selector: 'swc-calendar-overview',
  template: `
      <p-button type="button" class="mr-2" (click)="sidebarVisible = true" icon="pi pi-arrow-left"></p-button>
      <p-sidebar [(visible)]="sidebarVisible" position="right">
          <H1>Add Driver</H1>
          <swc-add-calendar-form (calendarForm)="addCalendar($event)"></swc-add-calendar-form>
      </p-sidebar>
      <p-table [value]="calendars">
          <ng-template pTemplate="header">
              <tr>
                  <th>Code</th>
                  <th>Name</th>
                  <th>Category</th>
                  <th>Quantity</th>
              </tr>
          </ng-template>
          <ng-template pTemplate="body" let-calendar>
              <tr>
                  <td>{{ calendar.name}}</td>
                  <td>{{ calendar.name}}</td>
                  <td>{{ calendar.name}}</td>
                  <td>{{ calendar.name}}</td>
              </tr>
          </ng-template>
      </p-table>
  `
})
export class CalendarOverviewComponent implements OnInit {

  calendars: Calendar[] = [];
  races: Race[] = []

  sidebarVisible: boolean = false;

  constructor(private service: CalendarService,
              private raceService: RaceService) {
  }

  ngOnInit() {
    this.retrieveCalendars();
  }

  retrieveCalendars() {
    this.service.getAll()
      .subscribe(
        data => {
          this.calendars = data
          console.log(data)
        }
      )
  }

  addCalendar(data: any) {
    console.log(data)
    this.service.create(data)
      .subscribe(() => {
        this.ngOnInit();
        this.sidebarVisible = false;
      });
  }

}
