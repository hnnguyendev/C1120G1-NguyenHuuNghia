import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.scss']
})
export class ProductEditComponent implements OnInit {

  refProduct: FormGroup;
  id: number;
  public origins;

  constructor(private _formBuilder: FormBuilder,
    private _productService: ProductService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this._productService.findAllOrigin().subscribe(data => {
      this.origins = data;
      console.log(this.origins);
    });

    this.formInit();

    this.id = this._activatedRoute.snapshot.params["id"];
    console.log(this.id);
    this.findProductById(this.id).subscribe(oldData => {
      this.refProduct.setValue(oldData);
      console.log(oldData.origin);
      console.log(this.refProduct.value);
    });
  }

  formInit() {
    this.refProduct = this._formBuilder.group({
      id: [""],
      name: ["", [Validators.required, Validators.minLength(5)]],
      price: ["", [Validators.required, Validators.min(10)]],
      manufactureDate: ["", [Validators.required]],
      quantity: ["", [Validators.required, Validators.min(0), Validators.max(100)]],
      origin: ["", [Validators.required]]
    });

  }

  findProductById(id: number) {
    return this._productService.findById(id);
  }

  submitEditForm() {
    if (this.refProduct.valid) {
      this._productService.update(this.refProduct.value).subscribe(data => {
        this._router.navigateByUrl("/home");
      }, error => {
        console.log(error);
      })
    }
  }

  // fix lỗi không bind được đối tượng lên <select></select>
  compareObjects(o1: any, o2: any): boolean {
    return o1.name === o2.name && o1._id === o2._id;
  }

}
