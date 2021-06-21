import {Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-lifecycle-hook',
  templateUrl: './lifecycle-hook.component.html',
  styleUrls: ['./lifecycle-hook.component.css']
})
export class LifecycleHookComponent implements OnInit, OnDestroy, OnChanges, DoCheck {

  @Input('total') total: number;
  totalOld: number;
  message: string = "";

  constructor() {
    console.log("constructor: LCH-cp");
  }

  ngDoCheck(): void {
    console.log("ngDoCheck: LCH-cp");
  }

  ngOnInit(): void {
    this.total +=1;
    console.log("ngOnInit: LCH-cp");
  }

  ngOnDestroy(): void {
    console.log("ngOnDestroy: LCH-cp");
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("ngOnChanges: LCH-cp");
    console.log(changes);
    this.totalOld = changes.total.previousValue;
    if (changes.total.firstChange) {
      this.message = "Wellcome ABC.. the first";
    } else {
      this.message = "";
    }
  }

}
