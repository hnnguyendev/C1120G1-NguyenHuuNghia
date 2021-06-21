import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import {FormsModule} from "@angular/forms";
import { AngularShowPetInfoComponent } from './angular-show-pet-info/angular-show-pet-info.component';
import { AngularUsingBootstrapComponent } from './angular-using-bootstrap/angular-using-bootstrap.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import {ChartModule} from 'primeng/chart';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    AngularShowPetInfoComponent,
    AngularUsingBootstrapComponent,
    CalculatorComponent,
    ColorPickerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ChartModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
