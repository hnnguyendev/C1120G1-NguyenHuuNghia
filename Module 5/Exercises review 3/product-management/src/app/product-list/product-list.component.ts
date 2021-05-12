import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  private _productList: Product[] = [];

  constructor(private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    // get all product after load list component
    this._productList = this._productService.productList;
  }

  getProductDetail(index: number) {
    console.log("Index to detail: " + index);
    this._router.navigate(["/detail", index]);
  }

  public get productList(): Product[] {
    return this._productList;
  }

}
