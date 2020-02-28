import { Component } from '@angular/core';

// load the component with the UI: as app.component.html
// apply the style sheet using app.component.ts
// place the output html in <app-root> placeholder in index.html

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = "Welcome to HR Application";
}