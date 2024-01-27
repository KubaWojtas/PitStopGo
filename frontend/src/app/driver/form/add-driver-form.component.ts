import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
    selector: 'swc-add-driver-form',
    template: `
        <div>
            <p-card styleClass="user-form" class="flex justify-content-center">
                <form [formGroup]="form" (ngSubmit)="addDriver()" novalidate>
                    <div class="field">
                        <label for="name" class="block">Name</label>
                        <input type="text" pInputText placeholder="Name" formControlName="name"/>
                        <small class="p-error block" *ngIf="form.get('name')?.invalid && form.get('name')?.dirty">
                            Name is required</small>
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
        name: ['', Validators.required],
        team: ['', Validators.required],
    });

    constructor(private fb: FormBuilder) { };

    addDriver() {
        console.log(this.form.value);
        this.driverForm.emit(this.form.value);
    }
}
