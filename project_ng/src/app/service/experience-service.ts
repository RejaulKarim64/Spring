import { isPlatformBrowser } from '@angular/common';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { Experience } from '../model/extracurricular.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  private apiUrl = environment.apiUrl + '/experience/';

  constructor(private http: HttpClient,
    @Inject(PLATFORM_ID) private platformId: Object
  ) { }



  // Add Experience
  addExperience(exp: Experience): Observable<Experience> {

    let headers = new HttpHeaders();

    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('authToken');
      if (token) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      }
    }

    return this.http.post<Experience>(`${this.apiUrl}add`, exp , { headers });
  }

  // Get all experiences for current JobSeeker
  getAllExperiences(): Observable<Experience[]> {
    let headers = new HttpHeaders();

    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('authToken');
      if (token) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      }
    }

    return this.http.get<Experience[]>(`${this.apiUrl}all`,  { headers });
  }

  // Delete by ID
  deleteExperience(id: number): Observable<void> {

     let headers = new HttpHeaders();

    if (isPlatformBrowser(this.platformId)) {
      const token = localStorage.getItem('authToken');
      if (token) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      }
    }
    return this.http.delete<void>(`${this.apiUrl}${id}` , { headers });
  }

  
}
