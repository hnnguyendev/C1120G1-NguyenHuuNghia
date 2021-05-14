import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductAddComponent } from './product-add/product-add.component';
import { ProductDeleteComponent } from './product-delete/product-delete.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductEditComponent } from './product-edit/product-edit.component';
import { ProductListComponent } from './product-list/product-list.component';


const routes: Routes = [
  {path: "home", component: ProductListComponent},
  {path: "add", component: ProductAddComponent},
  {path: "detail/:id", component: ProductDetailComponent},
  {path: "edit/:id", component: ProductEditComponent},
  {path: "delete/:id", component: ProductDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
