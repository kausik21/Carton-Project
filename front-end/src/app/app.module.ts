import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
// import {
//   MatSelectModule,MatCardModule,MatFormFieldModule,MatSliderModule} from '@angular/material';

import {FlexModule} from '@angular/flex-layout';
import {MatCardModule} from '@angular/material/card';
import {MatSliderModule} from '@angular/material/slider';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {ItemDetailsComponent} from './item-details/item-details.component';
import {PriceCalculatorComponent} from './price-calculator/price-calculator.component';
import {MatTableModule} from '@angular/material/table';
import {HttpClientModule} from '@angular/common/http';
import {MatDividerModule} from '@angular/material/divider';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
// import {MatCardModule, MatFormFieldModule, MatSelectModule, MatSliderModule} from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    ItemDetailsComponent,
    PriceCalculatorComponent
  ],
  imports: [
    MatCardModule,
    BrowserModule,
    MatSliderModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    FlexModule,
    MatTableModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatDividerModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
