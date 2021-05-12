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
    new Product("Samsung galaxy", 1000, new Date("2021-01-01"), 5, "Vietnam"),
    new Product("Nokia", 500, new Date("2021-01-01"), 0, "My"),
    new Product("Iphone", 1200, new Date("2021-01-01"), 20, "Anh"),
    new Product("LG", 600, new Date("2021-01-01"), 5, "Trung Quoc"),
    new Product("HTC", 400, new Date("2021-01-01"), 0, "Vietnam"),
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
