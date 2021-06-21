import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-using-bootstrap',
  templateUrl: './angular-using-bootstrap.component.html',
  styleUrls: ['./angular-using-bootstrap.component.scss']
})
export class AngularUsingBootstrapComponent implements OnInit {

  basicData: any;

  basicOptions: any;

  multiAxisData: any;

  chartOptions: any;

  multiAxisOptions: any;

  stackedData: any;

  stackedOptions: any;


  constructor() {
    this.basicData = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'My First dataset',
          backgroundColor: '#42A5F5',
          data: [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label: 'My Second dataset',
          backgroundColor: '#FFA726',
          data: [28, 48, 40, 19, 86, 27, 90]
        }
      ]
    };
    this.multiAxisData = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [{
        label: 'Dataset 1',
        backgroundColor: [
          '#EC407A',
          '#AB47BC',
          '#42A5F5',
          '#7E57C2',
          '#66BB6A',
          '#FFCA28',
          '#26A69A'
        ],
        yAxisID: 'y-axis-1',
        data: [65, 59, 80, 81, 56, 55, 10]
      }, {
        label: 'Dataset 2',
        backgroundColor: '#78909C',
        yAxisID: 'y-axis-2',
        data: [28, 48, 40, 19, 86, 27, 900]
      }]
    };

    this.multiAxisOptions = {
      responsive: true,
      tooltips: {
          mode: 'index',
          intersect: true
      },
      scales: {
          yAxes: [{
              type: 'linear',
              display: true,
              position: 'left',
              id: 'y-axis-1',
              ticks: {
                  min: 0,
                  // max: 100
              }
          },
          {
              type: 'linear',
              display: true,
              position: 'right',
              id: 'y-axis-2',
              gridLines: {
                  drawOnChartArea: false
              },
              ticks: {
                  min: 0,
                  // max: 100
              }
          }]
      }
  };
  }

  ngOnInit(): void {
  }



}
