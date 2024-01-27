import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";

@Component({
    selector: 'swc-add-track-form',
    template: `
        <div>
            <p-card styleClass="user-form" class="flex justify-content-center">
                <form [formGroup]="form" (ngSubmit)="addTrack()" novalidate>
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
export class AddTrackFormComponent {

    @Output()
    trackForm = new EventEmitter<any>();

    form = this.fb.group({
        name: ['', Validators.required]
    });

    constructor(private fb: FormBuilder) { };

    addTrack() {
        console.log(this.form.value);
        this.trackForm.emit(this.form.value);
        this.form.reset();
    }
}
