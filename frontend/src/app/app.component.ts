import {ApplicationRef, Component} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {AppModule} from "./app.module";
import {TabViewModule} from "primeng/tabview";
import {ButtonModule} from "primeng/button";
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {bootstrapApplication, BrowserModule} from "@angular/platform-browser";
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    imports: [
        AppModule,
        RouterOutlet,
    ],
    styleUrl: './app.component.css'
})
export class AppComponent {
    title = 'PitStopGo';
}
