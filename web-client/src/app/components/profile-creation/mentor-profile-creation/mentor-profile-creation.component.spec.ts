import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { MentorProfileCreationComponent } from './mentor-profile-creation.component';

describe('MentorProfileCreationComponent', () => {
  let component: MentorProfileCreationComponent;
  let fixture: ComponentFixture<MentorProfileCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorProfileCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorProfileCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
