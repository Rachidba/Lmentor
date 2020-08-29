import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

import { MustMatch } from 'src/app/helpers/mustMatchValidator';
import { RoleType } from 'src/app/models/RoleType';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, {
      validator: MustMatch('password', 'confirmPassword')
    });
  }

  get formControls() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    this.authenticationService.register({
      email: this.registerForm.controls.email.value,
      password: this.registerForm.controls.password.value,
      role: RoleType.ROLE_MENTOR
    }).subscribe(
      res => {
        this.router.navigate(['/login']);
      }, 
      err => {
        console.log('Error: ', err)
      }
    );
  }
}
