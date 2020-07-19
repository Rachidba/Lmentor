import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorCreationHeaderComponent } from './mentor-creation-header.component';

describe('MentorCreationHeaderComponent', () => {
  let component: MentorCreationHeaderComponent;
  let fixture: ComponentFixture<MentorCreationHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorCreationHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorCreationHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
