import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-dialog',
  templateUrl: './delete-dialog.component.html',
  styleUrls: ['./delete-dialog.component.scss']
})
export class DeleteDialogComponent implements OnInit {

  public id: number;

  constructor(private _dialogRef: MatDialogRef<DeleteDialogComponent>,
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
