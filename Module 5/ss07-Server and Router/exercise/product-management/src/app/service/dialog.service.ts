import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ProductDeleteDialogComponent } from '../product-delete-dialog/product-delete-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(private _matDialog: MatDialog) { }

  openDialog(id: number) {
    return this._matDialog.open(ProductDeleteDialogComponent, {
      // width: '500px',
      data: { id: id , message: "Are you sure you want delete this record?"},
      // disableClose: true,
      // panelClass: "foo"
    });
  }
}
