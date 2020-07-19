import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-mentor-creation-form',
  templateUrl: './mentor-creation-form.component.html',
  styleUrls: ['./mentor-creation-form.component.css']
})
export class MentorCreationFormComponent implements OnInit {

  mentorCreationForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.mentorCreationForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', []],
      title: ['', [Validators.required, Validators.maxLength(50)]],
      description: ['', []],
      sessionPrice: ['', Validators.required]
    }, {
    });
  }

  get formControls() { return this.mentorCreationForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.mentorCreationForm.invalid) {
      return;
    }
  }

}
