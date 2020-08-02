import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

import { MustMatch } from 'src/app/helpers/mustMatchValidator';
import { RegisterDto } from 'src/app/models/vo/RegisterVo';
import { RoleType } from 'src/app/models/RoleType';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder, private authenticationService: AuthenticationService) { }

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

    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
    var registerDto = new RegisterDto(this.registerForm.controls.email.value, this.registerForm.controls.password.value, RoleType.ROLE_MENTOR);
    this.authenticationService.register(registerDto).subscribe(res => {
      console.log('Succes with httpSatatus: ', res)
    }, 
    (err: HttpErrorResponse) => {
      console.log('Error: ', err)
    }
    );
  }

}
