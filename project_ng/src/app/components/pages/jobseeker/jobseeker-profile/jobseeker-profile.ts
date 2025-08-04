import { Component } from '@angular/core';
import { User } from '../../../../model/user.model';
import { Subscription } from 'rxjs';
import { AuthService } from '../../../../service/auth-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-jobseeker-profile',
  standalone: false,
  templateUrl: './jobseeker-profile.html',
  styleUrl: './jobseeker-profile.css'
})
export class JobseekerProfile {

  
   user: User | null = null;
  private subscription: Subscription = new Subscription();

  constructor(
    private authService: AuthService, // ✅ fixed spelling
    private router: Router

  ) { }

  ngOnInit(): void {

    console.log(this.authService.getToken());
    console.log(this.authService.getUserRole());
  
  }

}
