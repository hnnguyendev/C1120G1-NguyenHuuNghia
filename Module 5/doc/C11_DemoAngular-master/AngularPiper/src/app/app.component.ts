import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularPiper';

  public input1:string = "Ha Noi mua nay co nhieu mua";
  public inputNumber:number = 1.5;
  public money:number = 8;
  public now = new Date();
}
