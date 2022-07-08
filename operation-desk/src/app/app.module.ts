import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './components/app-component/app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DataTableComponent } from './components/data-table-component/data-table.component';


import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';  
import {MatSortModule} from '@angular/material/sort';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';



import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';

import { NgChartsModule } from 'ng2-charts';
import { HighchartsChartModule } from 'highcharts-angular';

@NgModule({
  declarations: [
    AppComponent,
    DataTableComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    HttpClientModule,
    FormsModule,
        ReactiveFormsModule,
        MatOptionModule,
        MatSelectModule,
        NgChartsModule,
        HighchartsChartModule
        
  ],
  providers: [],
  bootstrap: [AppComponent,DataTableComponent,]
})
export class AppModule { }
