import {Component, OnInit} from '@angular/core';
import {Track} from "../track/model/track.model";
import {TeamService} from "../service/team.service";
import {Team} from "./model/team.model";

@Component({
  selector: 'swc-team-overview',
  template: `
      <p-button type="button" class="mr-2" (click)="sidebarVisible = true" icon="pi pi-arrow-left"></p-button>
      <p-sidebar [(visible)]="sidebarVisible" position="right">
          <H1>Add Team</H1>
          <swc-add-team-form (teamForm)="addTeam($event)"></swc-add-team-form>
      </p-sidebar>
      <div class="flex justify-content-evenly flex-wrap ">
          <swc-team-card *ngFor="let team of teams"
                         [team]="team"
                         (deleteDriver)="deleteTeam($event)"
          ></swc-team-card>
      </div>
  `
})
export class TeamOverviewComponent implements OnInit{

  teams: Team[] = []

  sidebarVisible: boolean = false;

  constructor(private service: TeamService) {
  }


  ngOnInit() {
    this.retrieveTeams()
  }

  retrieveTeams() {
    return this.service.getAll()
        .subscribe(data => {
          console.log(data);
          this.teams = data;
        })
  }

  addTeam(data: any) {
    this.service.create(data)
        .subscribe(() => this.ngOnInit())
  }

  deleteTeam(data: any) {
    this.service.delete(data)
        .subscribe(() => this.ngOnInit())
  }
}
