import {Component, OnInit} from '@angular/core';
import {Track} from "../team/model/team.model";
import {TrackService} from "../service/track.service";

@Component({
  selector: 'swc-track-overview',
  template: `
    <swc-add-track-form (trackForm)="addTrack($event)"></swc-add-track-form>
    <div class="flex justify-content-evenly flex-wrap ">
          <swc-track-card *ngFor="let track of tracks"
                          [track] = track
                          (deleteTrack)="deleteTrack($event)"
          ></swc-track-card>
      </div>
  `
})
export class TrackOverviewComponent implements OnInit {

  tracks: Track[] = [];

  constructor(private service: TrackService) {
  }

  ngOnInit() {
    this.retrieveTracks();
  }

  retrieveTracks() {
    this.service.getAll()
        .subscribe(
            data => {
              this.tracks = data
              console.log(data)
            }
        )
  }

  addTrack(data: any) {
    console.log(data)
    this.service.create(data)
        .subscribe(() => this.ngOnInit());
  }

  deleteTrack(data: any) {
    console.log(data)
    this.service.delete(data)
        .subscribe(() => this.ngOnInit())
  }
}
