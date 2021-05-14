import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  public products;

  // products: Product[] = [];

  constructor(private _productService: ProductService) { }

  ngOnInit(): void {
    this.findAllProduct();
  }

  findAllProduct() {
    this._productService.findAll().subscribe(data => {
      this.products = data;
    }, error => {
      console.log(error);
    });
  }
  // findAllProduct() {
  //   this.products = this._productService.findAll();
  // }

}
