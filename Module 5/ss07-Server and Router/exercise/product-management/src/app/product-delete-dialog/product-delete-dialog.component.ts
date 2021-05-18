import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-product-delete-dialog',
  templateUrl: './product-delete-dialog.component.html',
  styleUrls: ['./product-delete-dialog.component.scss']
})
export class ProductDeleteDialogComponent implements OnInit {

  id: number;

  constructor(private _dialogRef: MatDialogRef<ProductDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data) {
    this.id = data.id;
  }

  ngOnInit(): void {
  }

  delete() {
    this._dialogRef.close(this.id);
  }

  onNoClick() {
    this._dialogRef.close();
  }

}
