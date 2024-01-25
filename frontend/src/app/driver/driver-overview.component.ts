import {Component, OnInit} from '@angular/core';
import {Driver} from "./model/driver.model";
import {DriverService} from "../services/driver.service";

@Component({
    selector: 'swc-driver-overview',
    template: `
        <p-button (click)="showDialog()" label="Show"></p-button>
        <p-dialog header="Header" [(visible)]="visible" [style]="{width: '50vw'}">
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </p-dialog>
        <div class="flex justify-content-evenly flex-wrap ">
            <swc-driver-card *ngFor="let driver of drivers"
                             Name="{{driver.name}}"
                             Team="{{driver.team}}"
            ></swc-driver-card>
        </div>
    `
})
export class DriverOverviewComponent implements OnInit {

    drivers: Driver[] | undefined

    visible: boolean = false;

    constructor(private service: DriverService) {
    }

    ngOnInit() {
        this.retrieveDrivers();
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

    showDialog() {
        this.visible = true;
    }


    protected readonly Driver = Driver;
}
