import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {AppModule} from "./app.module";
import {TabViewModule} from "primeng/tabview";
import {ButtonModule} from "primeng/button";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    AppModule,
    TabViewModule,
    ButtonModule,
    RouterLink
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'PitStopGo';
}
