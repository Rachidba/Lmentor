import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorCreationFormComponent } from './mentor-creation-form.component';

describe('MentorCreationFormComponent', () => {
  let component: MentorCreationFormComponent;
  let fixture: ComponentFixture<MentorCreationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorCreationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorCreationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
