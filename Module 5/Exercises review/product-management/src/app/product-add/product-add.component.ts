import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Product } from '../model/product';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.scss']
})
export class ProductAddComponent implements OnInit {

  @Output("productOutput") onCreate = new EventEmitter<Product>();

  public product: Product;

  constructor() { }

  ngOnInit(): void {
  }

  createProduct(name: string, price: string, manufactureDate: string, quantity: string, origin: string) {
    this.product = new Product(name, parseInt(price), new Date(manufactureDate), parseInt(quantity), origin);
    this.onCreate.emit(this.product);
  }

}
