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
import {TreeNode} from "primeng/api";

@Component({
  selector: 'swc-calendar-overview-V2',
  template: `
    <div class="card">
      <p-treetable [value]="files" [columns]="cols" [scrollable]="true" [tableStyle]="{'min-width':'50rem'}">
        <ng-template #header let-columns>
          <tr>
            <th *ngFor="let col of columns">
              {{ col.header }}
            </th>
          </tr>
        </ng-template>
        <ng-template #body let-rowNode let-rowData="rowData" let-columns="columns">
          <tr [ttRow]="rowNode">
            <td *ngFor="let col of columns; let i = index">
              <p-treeTableToggler [rowNode]="rowNode" *ngIf="i === 0" />
              {{ rowData[col.field] }}
            </td>
          </tr>
        </ng-template>
      </p-treetable>
    </div>
  `
})
export class CalendarOverviewV2Component implements OnInit {

  calendars: Calendar[] = [];
  tracks: Track[] = []

  files!: TreeNode[];

  cols!: Column[];

  constructor(private nodeService: NodeService) {}

  ngOnInit() {
    this.nodeService.getFilesystem().then((files) => (this.files = files));
    this.cols = [
      { field: 'name', header: 'Name' },
      { field: 'size', header: 'Size' },
      { field: 'type', header: 'Type' }
    ];
  }
}

interface Column {
  field: string;
  header: string;
}
