import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JobSeekerService {

  private baseUrl: string = environment.apiUrl + '/jobseeker/';
  constructor(
    private http: HttpClient
  ) { }

  registerJobSeeker(user:any ,jobSeeker: any, photo: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('user', new Blob([JSON.stringify(user)]));
    formData.append('jobSeeker', new Blob([JSON.stringify(jobSeeker)]));
    formData.append('photo', photo); 

    return this.http.post(this.baseUrl , formData);
  }
  
}
