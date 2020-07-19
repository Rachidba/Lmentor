import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorCreationExpertiseComponent } from './mentor-creation-expertise.component';

describe('MentorCreationExpertiseComponent', () => {
  let component: MentorCreationExpertiseComponent;
  let fixture: ComponentFixture<MentorCreationExpertiseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorCreationExpertiseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorCreationExpertiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
