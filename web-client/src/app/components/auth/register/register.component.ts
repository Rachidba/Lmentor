import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

import { MustMatch } from 'src/app/helpers/mustMatchValidator';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { RoleType } from 'src/app/models/RoleType';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted: boolean = false;
  emailAlreadyExists: boolean = false;
  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      // accountType: ['', Validators.required],
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
    this.emailAlreadyExists = false;
    if (this.registerForm.invalid) {
      return;
    }
    this.authenticationService.register({
      email: this.registerForm.controls.email.value,
      password: this.registerForm.controls.password.value,
      role: RoleType.ROLE_MENTOR
      // role: this.registerForm.controls.accountType.value
    }).subscribe(
      res => {
        this.snackBar.open("Votre compte a bien été créé", "S'authentifier", {
          duration: 5000,
        })
        this.router.navigate(['/login']);
      }, 
      (err: HttpErrorResponse) => {
        if (err.status == 409)
          this.emailAlreadyExists = true;
      }
    );
  }
}
