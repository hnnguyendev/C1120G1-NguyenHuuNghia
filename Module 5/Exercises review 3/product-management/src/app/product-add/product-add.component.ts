import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.scss']
})
export class ProductAddComponent implements OnInit {

  @Output("productOutput") onCreate = new EventEmitter<Product>();

  rfProduct: FormGroup;

  constructor(private _formBuilder: FormBuilder, 
              private _productService: ProductService,
              private _router: Router) { }

  ngOnInit(): void {
    this.rfProduct = this._formBuilder.group({
      name: ["", [Validators.required, Validators.minLength(5)]],
      price: ["", [Validators.required, Validators.min(10)]],
      manufactureDate: ["", [Validators.required]],
      quantity: ["", [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ["", [Validators.required]]
    })
  }

  submitCreateForm() {
    // let product: Product = {
    //   name: this.rfProduct.value["name"],
    //   price: this.rfProduct.value["price"],
    //   manufactureDate: this.rfProduct.value["manufactureDate"],
    //   quantity: this.rfProduct.value["quantity"],
    //   origin: this.rfProduct.value["origin"]
    // };
    // this.onCreate.emit(product);
    // console.log(this.rfProduct.value);
    if (this.rfProduct.valid) {
      this._productService.save(this.rfProduct.value)
      this._router.navigateByUrl("/home");
      // this.ngOnInit();
    }
  }

}
