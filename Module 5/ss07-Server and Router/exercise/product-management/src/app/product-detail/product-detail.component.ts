import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  public product;

  check: boolean = false;

  constructor(private _activatedRoute: ActivatedRoute,
    private _productService: ProductService) { }

  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.params["id"];
    this.findProductById(id);
  }

  findProductById(id: number) {
    return this._productService.findById(id).subscribe(data => {
      this.product = data;
      console.log("ok");
    }, error => {
      console.log("error");
    });
  }

  showInputForm() {
    this.check = true;
  }

  updateQuantity(newQuantity: string) {
    this.product.quantity = parseInt(newQuantity);
    this.check = false;
  }

}
