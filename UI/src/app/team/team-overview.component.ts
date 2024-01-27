import {Component, OnInit} from '@angular/core';
import {Team} from "../track/model/track.model";
import {TeamService} from "../service/team.service";

@Component({
  selector: 'swc-team-overview',
  template: `
    <swc-add-team-form (teamForm)="addTeam($event)"></swc-add-team-form>
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
