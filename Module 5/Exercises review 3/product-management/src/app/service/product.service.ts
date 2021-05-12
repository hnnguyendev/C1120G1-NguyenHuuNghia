import { Injectable } from '@angular/core';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private _productList: Product[] = [
    { name: "Samsung galaxy", price: 1000, manufactureDate: new Date("2021-01-01"), quantity: 5, origin: "Vietnam" },
    { name: "Nokia", price: 500, manufactureDate: new Date("2021-01-01"), quantity: 0, origin: "My" },
    { name: "Iphone", price: 1200, manufactureDate: new Date("2021-01-01"), quantity: 20, origin: "Anh" },
    { name: "LG", price: 600, manufactureDate: new Date("2021-01-01"), quantity: 5, origin: "Trung Quoc" },
    { name: "HTC", price: 400, manufactureDate: new Date("2021-01-01"), quantity: 0, origin: "Vietnam" }
  ];

  constructor() { }

  public get productList(): Product[] {
    return this._productList;
  }

  save(product: Product) {
    this._productList.push(product);
    console.log("Save: " + this._productList);
  }

  getProductById(index: number){
    return this._productList[index];
  }
}
