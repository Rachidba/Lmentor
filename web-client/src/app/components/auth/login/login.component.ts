import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/auth/authentication.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  incorrectEmailOrPassword: boolean = false;
  inverifiedEmail: boolean = false;
  commingFromEmailValidation: boolean = false;
  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
    const token = this.route.snapshot.queryParamMap.get('fromConfirmation');
    if (!!token && token == 'true')
      this.commingFromEmailValidation = true;
  }

  get formControls() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.incorrectEmailOrPassword = false;
    if (this.loginForm.invalid)
      return;

    this.authenticationService.login({
      email: this.loginForm.controls.email.value,
      password: this.loginForm.controls.password.value
    }).subscribe(res => {
      this.router.navigate(['/']);
    }, 
    (err: HttpErrorResponse) => {
      if (err.status == 423) {
        this.inverifiedEmail = true;
      } else {
        this.incorrectEmailOrPassword = true;
      }
    });
  }
}
