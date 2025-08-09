import { ChangeDetectorRef, Component } from '@angular/core';
import { User } from '../../../../model/user.model';
import { Subscription } from 'rxjs';
import { AuthService } from '../../../../service/auth-service';
import { Router } from '@angular/router';
import { Education } from '../../../../model/education';
import { JobSeekerService } from '../../../../service/job-seeker-service';
import { EducationService } from '../../../../service/education-service';

@Component({
  selector: 'app-jobseeker-profile',
  standalone: false,
  templateUrl: './jobseeker-profile.html',
  styleUrl: './jobseeker-profile.css'
})
export class JobseekerProfile {

  jobSeeker: any;

    educations: Education[] = [];

  newEducation = {
    level: '',
    institute: '',
    result: '',
    year: ''
  };

  constructor(
    private authService : AuthService,
    private jobSeekerService: JobSeekerService, 
    private cdr: ChangeDetectorRef,
    private educationService: EducationService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.getProfile();
    this.loadEducations();

  }


  loadEducations(): void {
    this.educationService.getEducations().subscribe({
      next: (data) => {
        this.educations = data;
        
        this.cdr.markForCheck();
       
      },
      error: (err) => {
        console.error('Failed to load educations', err);
      }
    });
  }

  getProfile() {

    this.jobSeekerService.getProfile().subscribe({
      next: (data) => {
        this.jobSeeker = data;
        console.log(data);
        this.cdr.markForCheck();

      },
      error: (err) => {
        console.error('Failed to load profile', err);
      }
    });
  }
  logout(){
    this.authService.logout();
    this.router.navigate(['login']);

  }


  addEducation(): void {
    this.educationService.addEducation(this.newEducation).subscribe({
      next: (addedEdu: any) => {
        if (!this.jobSeeker.educations) {
          this.jobSeeker.educations = [];
        }
        this.jobSeeker.educations.push(addedEdu);  // Update UI
        this.newEducation = { level: '', institute: '', result: '', year: '' };  // Reset form
      },
      error: (err) => {
        console.error('Failed to add education', err);
      }
    });
  }

}
