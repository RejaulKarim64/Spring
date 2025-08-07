import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUser } from './components/pages/user/all-user/all-user';
import { AddJobseeker } from './components/pages/jobseeker/add-jobseeker/add-jobseeker';
import { JobseekerProfile } from './components/pages/jobseeker/jobseeker-profile/jobseeker-profile';
import { Login } from './components/auth/login/login';
import { Logout } from './components/auth/logout/logout';

const routes: Routes = [

  {path: '', component:AllUser},
  {path: 'allUser', component:AllUser},
  {path: 'add-jobseeker',component: AddJobseeker},
  {path: 'jobsekpro',component: JobseekerProfile},
  {path: 'login',component: Login},
  {path: 'logout',component: Logout},
  {path: 'jobseeker',component: AddJobseeker},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
