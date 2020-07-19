import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorCreationPersonalComponent } from './mentor-creation-personal.component';

describe('MentorCreationPersonalComponent', () => {
  let component: MentorCreationPersonalComponent;
  let fixture: ComponentFixture<MentorCreationPersonalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorCreationPersonalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorCreationPersonalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
