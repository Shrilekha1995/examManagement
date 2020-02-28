import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from "src/app/view/view.component";
import { UploadComponent } from "src/app/upload/upload.component";


const routes: Routes = [
  {
  path:"view",
  component: ViewComponent
},
 {
  path:"upload",
  component: UploadComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
