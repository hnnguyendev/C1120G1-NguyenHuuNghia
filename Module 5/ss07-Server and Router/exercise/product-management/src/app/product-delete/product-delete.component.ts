import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.scss']
})
export class ProductDeleteComponent implements OnInit {

  public product;
  id: number;

  constructor(private _productService: ProductService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this._activatedRoute.snapshot.params["id"];
    console.log(this.id);
    this.findProductById(this.id);
  }

  findProductById(id: number) {
    return this._productService.findById(id).subscribe(data => {
      this.product = data;
    });
  }

  deleteProduct(id: number) {
    this._productService.delete(id).subscribe(data => {
      this._router.navigateByUrl("/home");
    }, error => {
      console.log(error);
    });

  }

}
