import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentCreateComponent} from "./student-module/student-create/student-create.component";
import {StudentListComponent} from "./student-module/student-list/student-list.component";
import {StudentDetailComponent} from "./student-module/student-detail/student-detail.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full' },
  // {path: '', redirect: 'home', pathMatch: 'full' }, //phien ban cu la redirect
  {path:"home", component:StudentListComponent},
  {path:"create", component:StudentCreateComponent},
  {path:"detail/:id", component:StudentDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
