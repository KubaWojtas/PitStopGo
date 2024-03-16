import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
    selector: 'swc-add-driver-form',
    template: `
        <div>
            <p-card styleClass="user-form" class="flex justify-content-center">
                <form [formGroup]="form" (ngSubmit)="addDriver()" novalidate>
                    <div class="field">
                        <label for="firstName" class="block">First name</label>
                        <input type="text" pInputText placeholder="First name" formControlName="firstName"/>
                        <small class="p-error block"
                               *ngIf="form.get('firstName')?.invalid && form.get('firstName')?.dirty">
                            First name is required</small>
                    </div>
                    <div class="field">
                        <label for="lastName" class="block">Last name</label>
                        <input type="text" pInputText placeholder="Last name" formControlName="lastName"/>
                        <small class="p-error block"
                               *ngIf="form.get('lastName')?.invalid && form.get('lastName')?.dirty">
                            Last name is required</small>
                    </div>
                    <div class="field">
                        <label for="dateOfBirth" class="block">Date of birth</label>
                        <input type="date" pInputText placeholder="Date of birth" formControlName="dateOfBirth"/>
                        <small class="p-error block"
                               *ngIf="form.get('dateOfBirth')?.invalid && form.get('dateOfBirth')?.dirty">
                            Date of birth is required</small>
                    </div>
                    <div class="field">
                        <label for="country" class="block">Country</label>
                        <input type="text" pInputText placeholder="Country" formControlName="country"/>
                        <small class="p-error block" *ngIf="form.get('country')?.invalid && form.get('country')?.dirty">
                            Country is required</small>
                    </div>
                    <div class="field">
                        <label for="number" class="block">Number</label>
                        <input type="number" pInputText [min]="2" [max]="99" placeholder="Number" formControlName="number"/>
                        <small class="p-error block" *ngIf="form.get('number')?.invalid && form.get('number')?.dirty">
                            Number is required</small>
                    </div>
                    <div class="field">
                        <label for="team" class="block">Team</label>
                        <input type="text" pInputText placeholder="Team" formControlName="team"/>
                        <small class="p-error block" *ngIf="form.get('team')?.invalid && form.get('team')?.dirty">
                            Team is required</small>
                    </div>
                    <button pButton type="submit" label="Submit" [disabled]="form.invalid"></button>
                </form>
            </p-card>
        </div>
    `
})
export class AddDriverFormComponent {

    @Output()
    driverForm = new EventEmitter<any>();

    form = this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        dateOfBirth: ['', Validators.required],
        country: ['', Validators.required],
        number: ['', Validators.required],
        team: [''],
    });

    constructor(private fb: FormBuilder) { };

    addDriver() {
        console.log(this.form.value);
        this.driverForm.emit(this.form.value);
        this.form.reset();
    }
}
