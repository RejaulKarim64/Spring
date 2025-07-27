import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl: string = environment.apiUrl + '/user/';

constructor(
  private http: HttpClient
) { }

public getAllEmp(): Observable<User[]> {
  return this.http.get<User[]>(this.baseUrl);
}

  
}
