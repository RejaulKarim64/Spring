import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddJobseeker } from './add-jobseeker';

describe('AddJobseeker', () => {
  let component: AddJobseeker;
  let fixture: ComponentFixture<AddJobseeker>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddJobseeker]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddJobseeker);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
