import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyMentorProfileComponent } from './my-mentor-profile.component';

describe('MyMentorProfileComponent', () => {
  let component: MyMentorProfileComponent;
  let fixture: ComponentFixture<MyMentorProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyMentorProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyMentorProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
