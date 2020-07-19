import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Store } from '@ngrx/store';
import * as fromRoot from '../../../state';
import { MentorCreationPersonal } from 'src/app/models/MentorCreationPersonal.interface';
import { map, take, distinctUntilChanged } from 'rxjs/operators';
import { merge } from 'rxjs';
import * as MentorCreationPersonalActions from './mentor-creation-personal.actions';

@Component({
  selector: 'app-mentor-creation-personal',
  templateUrl: './mentor-creation-personal.component.html',
  styleUrls: ['./mentor-creation-personal.component.css']
})

export class MentorCreationPersonalComponent implements OnInit {
  title = "Personal informations";
  submitted = false;
  personalForm = this.formBuilder.group(
    {
      gender: [null, Validators.required],
      firstName: [null, [Validators.required]],
      lastName: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      phoneNumber: [null, [Validators.required]],
      city: [null, [Validators.required]]
    },
    {
      updateOn: 'blur'
    }
  );

  genderCtrl = this.personalForm.get('gender');
  firstNameCtrl = this.personalForm.get('firstName');
  lastNameCtrl = this.personalForm.get('lastName');
  emailCtrl = this.personalForm.get('email');
  phoneNumberCtrl = this.personalForm.get('phoneNumber');
  cityCtrl = this.personalForm.get('city');

  constructor(private formBuilder: FormBuilder, private router: Router, private store: Store<fromRoot.State>) { }

  get formControls() { return this.personalForm.controls; }
  
  ngOnInit(): void {
    this.store.select(fromRoot.selectMentorCreationPersonalFormData)
              .pipe(take(1))
              .subscribe((mentorCreationPersonal: MentorCreationPersonal) => this.personalForm.patchValue(mentorCreationPersonal, { emitEvent: false }));

    const gender$ = this.genderCtrl.valueChanges.pipe(
      map((gender: string) => ({ gender } as Partial<MentorCreationPersonal>))
    );
    const firstName$ = this.firstNameCtrl.valueChanges.pipe(
      map((firstName: string) => ({ firstName } as Partial<MentorCreationPersonal>))
    );
    const lastName$ = this.lastNameCtrl.valueChanges.pipe(
      map((lastName: string) => ({ lastName } as Partial<MentorCreationPersonal>) )
    );
    const email$ = this.emailCtrl.valueChanges.pipe(
      map((email: string) => ({ email } as Partial<MentorCreationPersonal>) )
    );
    const phoneNumber$ = this.phoneNumberCtrl.valueChanges.pipe(
      map((phoneNumber: string) => ({ phoneNumber } as Partial<MentorCreationPersonal>) )
    );
    const city$ = this.cityCtrl.valueChanges.pipe(
      map((city: string) => ({ city } as Partial<MentorCreationPersonal>) )
    );

    merge(gender$, firstName$, lastName$, email$, phoneNumber$, city$).subscribe(
      (payload: Partial<MentorCreationPersonal>) => {
        this.store.dispatch(
          new MentorCreationPersonalActions.PatchMentorPersonal(payload)
        );
      }
    );

    this.personalForm.valueChanges
      .pipe(
        map(() => this.personalForm.valid),
        distinctUntilChanged()
      )
      .subscribe((isValid: boolean) =>
        this.store.dispatch(
          new MentorCreationPersonalActions.ChangeValidationStatus(isValid)
        )
      );
  }

  goToNextStep() {
    this.submitted = true;
    if (this.personalForm.invalid)
      return;
      
    this.router.navigate(['MentorCreationExpertise']);
  }
}
