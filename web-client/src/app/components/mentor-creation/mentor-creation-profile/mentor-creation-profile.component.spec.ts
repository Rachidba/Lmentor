import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorCreationProfileComponent } from './mentor-creation-profile.component';

describe('MentorCreationProfileComponent', () => {
  let component: MentorCreationProfileComponent;
  let fixture: ComponentFixture<MentorCreationProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorCreationProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorCreationProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
