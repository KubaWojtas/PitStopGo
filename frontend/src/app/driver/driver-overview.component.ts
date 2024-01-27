import {Component, OnInit} from '@angular/core';
import {Driver} from "./model/driver.model";
import {DriverService} from "../service/driver.service";

@Component({
    selector: 'swc-driver-overview',
    template: `
        <swc-add-driver-form (driverForm)="addDriver($event)"></swc-add-driver-form>
        <div class="flex justify-content-evenly flex-wrap ">
            <swc-driver-card *ngFor="let driver of drivers"
                             [driver]="driver"
                             (deleteDriver)="deleteDriver($event)"
            ></swc-driver-card>
        </div>
    `
})
export class DriverOverviewComponent implements OnInit {

    drivers: Driver[] = [];

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

    addDriver(data: any) {
        console.log(data)
        this.service.create(data)
            .subscribe(() => this.ngOnInit());
    }

    deleteDriver(data: any) {
        console.log(data)
        this.service.delete(data)
            .subscribe(() => this.ngOnInit())
    }
}
