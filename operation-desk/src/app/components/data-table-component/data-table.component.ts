import { Component, OnInit } from '@angular/core';

/**Packages to implement paginator**/
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';

/**Package used to implement various functionalities**/
import { MatTableDataSource } from '@angular/material/table';


import { DataService } from '../../services/data.service';


/**Employee interface**/
import { Employee } from '../../models/employee';


import { ChartData, ChartOptions } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';

import * as Highcharts from 'highcharts';

import TileMapModule from "highcharts/modules/tilemap";
import MapModule from "highcharts/modules/map";
import { FullDetail } from 'src/app/models/fullDetail';


interface TimePeriod {
  value: String;
  viewValue: string;
}

MapModule(Highcharts);
TileMapModule(Highcharts);




@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.css']
})





export class DataTableComponent implements OnInit, AfterViewInit {


  EMPLOYEE_DATA!: Employee[];

  counts: { [key: string]: number[] } = { 'job_km': [0, 1, 2, 3] };

  labelName: string[] = [];

  labelData: number[][] = [];

  transactionData: ChartData<'bar'> = {
    labels: [],
    datasets: [
      { label: 'Success', data: [], stack: 'a' },
      { label: 'Failure', data: [], stack: 'a' },
      { label: 'In Progress', data: [], stack: 'a' },
      { label: 'Not Started', data: [], stack: 'a' },
    ],
  };


  chartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      title: {
        display: true,
        text: 'Transaction Data',
      },
    },
  };





  displayedColumns: string[] = ['id', 'job_NM', 'job_START_TS', 'job_END_TS', 'duration', 'status'];

  dataSource !: MatTableDataSource<Employee>;

  baseUrl = "http://localhost:8080/api/";




  /**Filter Function**/
  applyFilter(event: Event) {
    console.log(this.dataSource);
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }



  /**Paginator**/
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  ngAfterViewInit() {

  }



  /**Run on intialization**/
  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.getData("http://localhost:8080/api/all");
    this.Detailed_Data.push({ businessdate: "25/02/2022", custrefno: "CUSTI45897", filename: "CDFILENM", indivtxnid: "ID45HJL", jobdatarecordtext: "HJKSLJD", jobid: "5", jobname: "JOB_CM", jobstatuscode: "Complete", jobstepname: "Wire.1", jonstepstatus: "BACKEND_COMPLETE", mfdtrnno: "MFD25022022" });
  }










  timePeriods: TimePeriod[] = [
    { value: this.baseUrl + "all", viewValue: 'All' },
    { value: this.baseUrl + "1", viewValue: 'Today' },
    { value: this.baseUrl + "2", viewValue: 'Yesterday' },
    { value: this.baseUrl + "3", viewValue: 'Last 3 Days' },
    { value: this.baseUrl + "4", viewValue: 'Last 4 Days' },
    { value: this.baseUrl + "5", viewValue: 'Last 5 Days' },
    { value: this.baseUrl + "6", viewValue: 'Last 6 Days' },
    { value: this.baseUrl + "7", viewValue: 'Last 7 Days' },

  ];



  getData(url: string) {

    this.dataService.setTest(url);
    this.dataService.getEmployees().subscribe((data: Employee[]) => {
      this.EMPLOYEE_DATA = data;
      this.dataSource = new MatTableDataSource<Employee>(this.EMPLOYEE_DATA);
      this.dataSource.paginator = this.paginator;


      this.labelName = [];
      this.labelData = [];
      this.counts = {}
      this.transactionData.datasets[0].data = [];
      this.transactionData.datasets[1].data = [];
      this.transactionData.datasets[2].data = [];
      this.transactionData.datasets[3].data = [];

      const locations = [];

      for (let i = 0; i < 10; i++) {
        for (let j = 0; j < 10; j++) {
          locations.push({ x: j, y: i });
        }
      }



      for (let i = 0; i < data.length; i++) {

        var x = data[i].job_NM || "";
        var y = data[i].status || "";
        var k = 0;

        if (this.counts[x] === undefined) {
          this.counts[x] = [];
        }

        switch (y) {
          case "Success": {
            k = 0;
            break;
          }
          case "Failure": {
            k = 1;
            break;
          }
          case "In Progress": {
            k = 2;
            break;
          }
          case "Not Started": {
            k = 3;
            break;
          }
        }



        this.counts[x][k] = (this.counts[x][k] || 0) + 1;

        if (i < 100) {
          this.options.series[0]['data'].push({ x: locations[i].x, y: locations[i].y, value: k, description: data[i].job_NM, status: data[i].status, label: data[i].id, });
        }


      }



      for (const key in this.counts) {
        this.labelName.push(key);
        this.labelData.push(this.counts[key]);
        this.transactionData.datasets[0].data.push(this.counts[key][0]);
        this.transactionData.datasets[1].data.push(this.counts[key][1]);
        this.transactionData.datasets[2].data.push(this.counts[key][2]);
        this.transactionData.datasets[3].data.push(this.counts[key][3]);
      }



      this.transactionData.labels = this.labelName;
      this.chart.chart?.update();




      Highcharts.chart('container', this.options);
    });


  }


  dateFilter(timeValue: string) {
    this.getData(timeValue);
  }

  @ViewChild(BaseChartDirective)
  public chart!: BaseChartDirective;



  ///***Honey Comb */

  public options: any = {
    chart: {
      type: 'tilemap',
      height: 700
    },
    xAxis: {
      visible: false
    },
    yAxis: {
      visible: false
    },
    title: {
      text: 'Transactions'
    },
    tooltip: {
      headerFormat: '',
      pointFormat: 'Transaction of type <b>{point.description}</b> have status:<b>{point.status}</b>'
    },
    credits: {
      enabled: false
    },
    colorAxis: {
      dataClasses: [{
        from: 0,
        to: 0,
        color: '#FF2371',
        name: 'Success'
      }, {
        from: 1,
        to: 1,
        color: '#FFC428',
        name: 'Failure'
      }, {
        from: 2,
        to: 2,
        color: '#FF7987',
        name: 'In Progress'
      }, {
        from: 3,
        to: 3,
        color: '#F9EDB3',
        name: 'Not Started'
      }]
    },
    plotOptions: {
      series: {
        dataLabels: {
          enabled: true,
          format: '{point.label}',
          color: '#000000',
        }
      }
    },
    series: [
      {
        name: 'Normal',
        turboThreshold: 500000,
        data: []
      }
    ]
  }

  Detailed_Data: FullDetail[] = [];

  getDetails(employee: Employee) {
    this.Detailed_Data = [];
    const detailUrl = "http://localhost:8080/api/detail/" + employee.id;
    this.dataService.setDetailTest(detailUrl);
    this.dataService.getFullDetail().subscribe((data: FullDetail[]) => {
    this.Detailed_Data.push(data[0]);
      console.log(data);
    });
    console.log(this.Detailed_Data);

  }

}






