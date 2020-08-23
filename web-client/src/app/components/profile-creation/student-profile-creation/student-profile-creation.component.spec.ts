import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentProfileCreationComponent } from './student-profile-creation.component';

describe('StudentProfileCreationComponent', () => {
  let component: StudentProfileCreationComponent;
  let fixture: ComponentFixture<StudentProfileCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentProfileCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentProfileCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
