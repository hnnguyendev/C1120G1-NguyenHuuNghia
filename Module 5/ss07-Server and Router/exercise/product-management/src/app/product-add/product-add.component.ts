import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.scss']
})
export class ProductAddComponent implements OnInit {

  refProduct: FormGroup;
  public origins;

  constructor(private _formBuilder: FormBuilder,
    private _productService: ProductService,
    private _router: Router) { }

  ngOnInit(): void {
    this._productService.findAllOrigin().subscribe(data => {
      this.origins = data;
      console.log(this.origins);
    });

    this.formInit();
  }

  formInit() {
    this.refProduct = this._formBuilder.group({
      name: ["", [Validators.required, Validators.minLength(5)]],
      price: ["", [Validators.required, Validators.min(10)]],
      manufactureDate: ["", [Validators.required]],
      quantity: ["", [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ["", [Validators.required]]
    });
  }

  submitCreateForm() {
    if (this.refProduct.valid) {
      this._productService.save(this.refProduct.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      }, error => {
        console.log(error);
      })
    }
  }

}
