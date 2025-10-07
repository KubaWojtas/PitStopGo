import {Component, OnInit} from '@angular/core';
import {Driver} from "../driver/model/driver.model";
import {Team} from "../team/model/team.model";
import {DriverService} from "../service/driver.service";
import {TeamService} from "../service/team.service";
import {CalendarService} from "../service/calendar.service";
import {RaceService} from "../service/race.service";
import {Calendar} from "./model/calendar.model";
import {Race} from "./race/race.model";
import {TableRowExpandEvent} from "primeng/table";
import {TrackService} from "../service/track.service";
import {Track} from "../track/model/track.model";

@Component({
  selector: 'swc-calendar-overview',
  template: `
    <p-button type="button" class="mr-2" (click)="sidebarVisible = true" icon="pi pi-arrow-left"></p-button>
    <p-sidebar [(visible)]="sidebarVisible" position="right">
      <H1>Add Driver</H1>
      <swc-add-calendar-form (calendarForm)="addCalendar($event)"></swc-add-calendar-form>
    </p-sidebar>
    <!--      <p-table [value]="calendars">-->
    <!--          <ng-template pTemplate="header">-->
    <!--              <tr>-->
    <!--                  <th>Name</th>-->
    <!--                  <th>Races</th>-->
    <!--              </tr>-->
    <!--          </ng-template>-->
    <!--          <ng-template pTemplate="body" let-calendar>-->
    <!--              <tr>-->
    <!--                  <td>{{ calendar.name}}</td>-->
    <!--                  <td>{{ countRaces(calendar)}}</td>-->
    <!--              </tr>-->
    <!--          </ng-template>-->
    <!--      </p-table>-->
    <p-table [value]="calendars" dataKey="calendarId" [tableStyle]="{ 'min-width': '60rem' }">
      <ng-template pTemplate="header">
        <tr>
          <th style="width: 5rem"></th>
          <th pSortableColumn="name">Name
            <p-sortIcon field="name"/>
          </th>
          <th pSortableColumn="races">Races
            <p-sortIcon field="races"/>
          </th>
        </tr>
      </ng-template>
      <ng-template pTemplate="body" let-calendar let-expanded="expanded">
        <tr>
          <td>
            <p-button type="button" pRipple [pRowToggler]="calendar" [text]="true" [rounded]="true" [plain]="true"
                      [icon]="expanded ? 'pi pi-chevron-down' : 'pi pi-chevron-right'"/>
          </td>
          <td>{{ calendar.name }}</td>
          <td>{{ countRaces(calendar) }}</td>
          <!--            <td><p-button label="Add race" (onClick)="addRace(calendar.calendarId)"></p-button></td>-->
          <!--            <td><p-button label="Simulate" (onClick)="simulateCalendar(calendar.calendarId)"></p-button></td>-->
        </tr>
      </ng-template>
      <ng-template pTemplate="rowexpansion" let-calendar>
        <tr>
          <td colspan="7">
            <div class="p-3">
              <p-table [value]="calendar.races" dataKey="raceID">
                <ng-template pTemplate="header">
                  <tr>
                    <th style="width: 5rem"></th>
                    <th pSortableColumn="id">Id
                      <p-sortIcon field="raceId"/>
                    </th>
                    <th style="width: 4rem"></th>
                  </tr>
                </ng-template>
                <ng-template pTemplate="body" let-race>
                  <tr>
                    <td>
                      <p-button type="button" pRipple [pRowToggler]="calendar" [text]="true" [rounded]="true"
                                [plain]="true"/>
                    </td>
                    <td>{{ race.raceId }}</td>
                  </tr>
                </ng-template>
                <ng-template #emptymessage>
                  <tr>
                    <td colspan="6">There are no races for this calendar yet.</td>
                  </tr>
                </ng-template>
              </p-table>
            </div>
          </td>
        </tr>
      </ng-template>
      <ng-template pTemplate="rowexpansion" let-race>
        <tr>
          <td colspan="7">
            <div class="p-3">
              <p-table [value]="race.resultaten" dataKey="resultID">
                <ng-template pTemplate="header">
                  <tr>
                    <th pSortableColumn="position">Position
                      <p-sortIcon field="raceId"/>
                    </th>
                    <th pSortableColumn="name">Name
                      <p-sortIcon field="raceId"/>
                    </th>
                    <th pSortableColumn="points">Points
                      <p-sortIcon field="raceId"/>
                    </th>
                    <th style="width: 4rem"></th>
                  </tr>
                </ng-template>
                <ng-template pTemplate="body" let-result>
                  <tr>
                    <td>{{ result.id }}</td>
                    <td>{{ result.id }}</td>
                    <td>{{ result.points }}</td>
                  </tr>
                </ng-template>
                <ng-template #emptymessage>
                  <tr>
                    <td colspan="6">There are no races for this calendar yet.</td>
                  </tr>
                </ng-template>
              </p-table>
            </div>
          </td>
        </tr>
      </ng-template>
    </p-table>
  `
})
export class CalendarOverviewComponent implements OnInit {

  calendars: Calendar[] = [];
  tracks: Track[] = []

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

  countRaces(calendar: Calendar) {
    return calendar.races?.length;
  }

  addRace(id: string) {
    console.log(id)
    this.service.addRace(id, "6c651b64-bc2d-48d1-870c-cfb1763c02b5")
      .subscribe(
        data => {
          console.log(data)
        }
      )
  }

  simulateCalendar(id: string) {
    console.log(id)
    this.service.simulateCalendar(id)
      .subscribe(
        date => {
          console.log(date)
        }
      )
  }
}
