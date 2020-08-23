import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  get formControls() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid)
      return;

    this.authenticationService.login({
      email: this.loginForm.controls.email.value,
      password: this.loginForm.controls.password.value
    }).subscribe(res => {
      console.log('Succes with httpSatatus: ', res)
      this.authenticationService.authChange.next(true);
    }, 
    (err: HttpErrorResponse) => {
      console.log('Error: ', err)
    });
  }

  

}
