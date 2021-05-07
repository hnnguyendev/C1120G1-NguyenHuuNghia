import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit {

  public firstOperand: number;
  public secondOperand: number;
  public result;
  public operator = "+";

  constructor() { }

  ngOnInit(): void {
  }

  changeFirstOperand(firstOperand: string) {
    this.firstOperand = parseInt(firstOperand);
  }

  changeSecondOperand(secondOperand: string) {
    this.secondOperand = parseInt(secondOperand);
  }

  changeOperator(operator) {
    this.operator = operator;
  }

  calculate() {
    switch (this.operator) {
      case "+":
        this.result = this.firstOperand + this.secondOperand;
        break;
      case "-":
        this.result = this.firstOperand - this.secondOperand;
        break;
      case "*":
        this.result = this.firstOperand * this.secondOperand;
        break;
      case "/":
        if (this.secondOperand === 0) {
          this.result = "Can not divide zero!";
        } else {
          this.result = this.firstOperand / this.secondOperand;
        }
        break;
    }
  }

}
