import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
    selector: 'swc-add-team-form',
    template: `
        <div>
            <p-card styleClass="user-form" class="flex justify-content-center">
                <form [formGroup]="form" (ngSubmit)="addTeam()" novalidate>
                    <div class="field">
                        <label for="name" class="block">Name</label>
                        <input type="text" pInputText placeholder="Name" formControlName="name"/>
                        <small class="p-error block" *ngIf="form.get('name')?.invalid && form.get('name')?.dirty">
                            Name is required</small>
                    </div>
                    <button pButton type="submit" label="Submit" [disabled]="form.invalid"></button>
                </form>
            </p-card>
        </div>
    `
})
export class AddTeamFormComponent {

    @Output()
    teamForm = new EventEmitter<any>();

    form = this.fb.group({
        name: ['', Validators.required]
    });

    constructor(private fb: FormBuilder) { };

    addTeam() {
        console.log(this.form.value);
        this.teamForm.emit(this.form.value);
        this.form.reset();
    }
}
