import { NgModule, provideBrowserGlobalErrorListeners, provideZonelessChangeDetection } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { AddJobseeker } from './components/pages/jobseeker/add-jobseeker/add-jobseeker';
import { AllUser } from './components/pages/user/all-user/all-user';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { JobseekerProfile } from './components/pages/jobseeker/jobseeker-profile/jobseeker-profile';
import { Login } from './components/auth/login/login';
import { Logout } from './components/auth/logout/logout';

@NgModule({
  declarations: [
    App,
    AddJobseeker,
    AllUser,
    JobseekerProfile,
    Login,
    Logout
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZonelessChangeDetection(),
    provideClientHydration(withEventReplay()),
    provideHttpClient(
      withFetch()
    )
  ],
  bootstrap: [App]
})
export class AppModule { }
