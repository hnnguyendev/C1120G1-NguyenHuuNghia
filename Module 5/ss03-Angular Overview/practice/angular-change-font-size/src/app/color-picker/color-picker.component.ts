import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.scss']
})
export class ColorPickerComponent implements OnInit {

  public bgColor: string = "#23D18B";

  constructor() { }

  ngOnInit(): void {
  }

  pickColor(bgColor: string) {
    this.bgColor = bgColor;
  }

}
