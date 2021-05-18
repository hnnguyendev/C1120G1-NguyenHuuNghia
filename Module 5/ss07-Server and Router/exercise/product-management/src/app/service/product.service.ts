import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // products: Product[] = [
  //   { id: 1, name: "Samsung galaxy", price: 1000, manufactureDate: new Date("2021-01-01"), quantity: 5, origin: "Vietnam" },
  //   { id: 2, name: "Nokia", price: 500, manufactureDate: new Date("2021-01-01"), quantity: 0, origin: "My" },
  //   { id: 3, name: "Iphone", price: 1200, manufactureDate: new Date("2021-01-01"), quantity: 20, origin: "Anh" },
  //   { id: 4, name: "LG", price: 600, manufactureDate: new Date("2021-01-01"), quantity: 5, origin: "Trung Quoc" },
  //   { id: 5, name: "HTC", price: 400, manufactureDate: new Date("2021-01-01"), quantity: 0, origin: "Vietnam" }
  // ];

  private API_URL = "http://localhost:3000/products";
  private API_URL2 = "http://localhost:3000/origins";

  constructor(private _httpClient: HttpClient) { }

  findAllOrigin(): Observable<any> {
    return this._httpClient.get(this.API_URL2);
  }

  findAll(): Observable<any> {
    return this._httpClient.get(this.API_URL);
  }

  save(product: any): Observable<any> {
    return this._httpClient.post(this.API_URL, product);
  }

  findById(id: number): Observable<any> {
    return this._httpClient.get(`${this.API_URL}/${id}`);
  }

  update(product: any): Observable<any> {
    return this._httpClient.put(`${this.API_URL}/${product.id}`, product);
  }

  delete(id: number): Observable<any> {
    return this._httpClient.delete(`${this.API_URL}/${id}`);
  }

  search(txtSearch: string, txtSearch2: string): Observable<any> {
    return this._httpClient.get(`${this.API_URL}?name_like=${txtSearch}&price_like=${txtSearch2}`);
    // search(txtSearch: string): Observable<any> {
    // return this._httpClient.get(`${this.API_URL}?q=${txtSearch}`);
    // return this._httpClient.get(`${this.API_URL}?name_like=${txtSearch}`);
  }

  searchByName(txtSearch: string): Observable<any> {
    return this._httpClient.get(`${this.API_URL}?name_like=${txtSearch}`);
  }

  searchByPrice(txtSearch: string): Observable<any> {
    return this._httpClient.get(`${this.API_URL}?price_like=${txtSearch}`);
  }

  searchByOrigin(txtSearch: string): Observable<any> {
    return this._httpClient.get(`${this.API_URL}?origin.name_like=${txtSearch}`);
  }

  // findAll() {
  //   return this.products;
  // }

  // save(product: Product) {
  //   this.products.push(product);
  //   console.log("Save: " + this.products);
  // }

  // findById(id: number) {
  //   return this.products.find(product => product.id == id);
  // }

  // update(id: number, product: Product) {
  //   for (let i = 0; i < this.products.length; i++) {
  //     if (this.products[i].id == id) {
  //       this.products[i] = product;
  //     }
  //   }
  // }

  // delete(id: number) {
  //   this.products = this.products.filter(product => {
  //     return product.id != id;
  //   });
  // }

}
