import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../model/product';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  @Input("productInput") productDetail: Product;

  public check: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  showInputForm() {
    this.check = true;
  }

  updateQuantity(newQuantity:string) {
    this.productDetail.quantity = parseInt(newQuantity);
    this.check = false;
  }

}
