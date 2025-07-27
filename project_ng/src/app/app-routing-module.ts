import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUser } from './components/pages/user/all-user/all-user';
import { AddJobseeker } from './components/pages/jobseeker/add-jobseeker/add-jobseeker';

const routes: Routes = [

  {path: '', component:AllUser},
  {path: 'add-jobseeker',component: AddJobseeker},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
