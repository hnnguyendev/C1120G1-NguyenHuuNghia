import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularLifecycle';

  total:number = 0;
  a:number = 0;
  b:number = 0;
  isDisplay:boolean = true;
  // @ts-ignore
  // abc = StudentMan.create({id:"1",name:"abc"});

  sum() {
    this.total = this.a + this.b;
  }

  onToggle() {
    this.isDisplay = !this.isDisplay;
  }
}
