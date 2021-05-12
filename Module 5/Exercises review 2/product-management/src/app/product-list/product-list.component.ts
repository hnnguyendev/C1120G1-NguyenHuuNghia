import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  public product: Product;

  public productList: Product[] = [
    {name: "Samsung galaxy", price: 1000, manufactureDate: new Date("2021-01-01"), quantity: 5, origin:"Vietnam"},
    {name: "Nokia", price: 500, manufactureDate: new Date("2021-01-01"), quantity: 0, origin:"My"},
    {name: "Iphone", price: 1200, manufactureDate: new Date("2021-01-01"), quantity: 20, origin:"Anh"},
    {name: "LG", price: 600, manufactureDate: new Date("2021-01-01"), quantity: 5, origin:"Trung Quoc"},
    {name: "HTC", price: 400, manufactureDate: new Date("2021-01-01"), quantity: 0, origin:"Vietnam"}
  ];

  constructor() { }

  ngOnInit(): void {
  }

  getProductDetail(product: Product) {
    this.product = product;
  }

  getProductFromCreateForm(value: Product) {
    this.productList.push(value);
  }

}
