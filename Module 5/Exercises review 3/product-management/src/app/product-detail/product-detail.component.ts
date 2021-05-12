import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  public product: Product;

  public check: boolean = false;

  constructor(private _activatedRoute: ActivatedRoute, 
              private _productService: ProductService) { }

  ngOnInit(): void {
    let index = this._activatedRoute.snapshot.params["id"];
    this.product = this._productService.getProductById(index);
  }

  showInputForm() {
    this.check = true;
  }

  updateQuantity(newQuantity:string) {
    this.product.quantity = parseInt(newQuantity);
    this.check = false;
  }

}
