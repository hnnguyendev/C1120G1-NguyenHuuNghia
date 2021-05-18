import { Component, OnInit } from '@angular/core';
import { DialogService } from '../service/dialog.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  p: number = 1;
  public products;
  public txtSearch: string = "";
  public txtSearch2: string = "";
  public searchBy: number = 1;

  constructor(private _productService: ProductService,
    private _dialogService: DialogService) { }

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

  // onDelete(id: number): void {
  //   const dialogRef = this._matDialog.open(ProductDeleteDialogComponent, {
  //     width: '500px',
  //     data: { id: id },
  //     // disableClose: true,
  //     // panelClass: "foo"
  //   });

  //   dialogRef.afterClosed().subscribe(result => {
  //     if (result) {
  //       this._productService.delete(id).subscribe(() => {
  //         this.findAllProduct();
  //       })
  //     }
  //   });
  // }

  onDelete(id: number): void {
    this._dialogService.openDialog(id).afterClosed().subscribe(result => {
      if (result) {
        this._productService.delete(id).subscribe(() => {
          this.findAllProduct();
        });
      }
    });
  }

  search() {
    // this._productService.search(this.txtSearch).subscribe(data => {
    //   this.products = data;
    // });

    this._productService.search(this.txtSearch, this.txtSearch2).subscribe(data => {
      this.products = data;
    });


    // if (this.searchBy == 1) {
    //   this._productService.searchByName(this.txtSearch).subscribe(data => {
    //     this.products = data;
    //   });
    // } else if (this.searchBy == 2) {
    //   this._productService.searchByPrice(this.txtSearch).subscribe(data => {
    //     this.products = data;
    //   });
    // } else if (this.searchBy == 3) {
    //   this._productService.searchByOrigin(this.txtSearch).subscribe(data => {
    //     this.products = data;
    //   });
    // }
  }

}
