import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {

  rfProduct: FormGroup;
  id: number;

  constructor(private _formBuilder: FormBuilder,
    private _productService: ProductService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.formInit();
  }

  formInit() {
    this.rfProduct = this._formBuilder.group({
      id: [""],
      name: ["", [Validators.required, Validators.minLength(5)]],
      price: ["", [Validators.required, Validators.min(10)]],
      manufactureDate: ["", [Validators.required]],
      quantity: ["", [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ["", [Validators.required]]
    });

    this.id = this._activatedRoute.snapshot.params["id"];
    console.log(this.id);
    this.findProductById(this.id).subscribe(oldData => {
      this.rfProduct.setValue(oldData);
    })
  }

  findProductById(id: number) {
    return this._productService.findById(id);
  }

  submitEditForm() {
    if (this.rfProduct.valid) {
      this._productService.update(this.rfProduct.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      }, error => {
        console.log(error);
      })
    }
  }

  // submitEditForm() {
  //   if (this.rfProduct.valid) {
  //     this._productService.update(this.id, this.rfProduct.value)
  //     this._router.navigateByUrl("/home");
  //     // this.ngOnInit();
  //   }
  // }

}
