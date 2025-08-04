import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobseekerProfile } from './jobseeker-profile';

describe('JobseekerProfile', () => {
  let component: JobseekerProfile;
  let fixture: ComponentFixture<JobseekerProfile>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobseekerProfile]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JobseekerProfile);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
