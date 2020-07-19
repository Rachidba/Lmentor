import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mentor-creation-profile',
  templateUrl: './mentor-creation-profile.component.html',
  styleUrls: ['./mentor-creation-profile.component.css']
})
export class MentorCreationProfileComponent implements OnInit {

  title = "Profile informations"
  submitted = false;
  profileForm = this.formBuilder.group(
    {
      title: [null, Validators.required],
      description: [null]
    }
  );

  constructor(private formBuilder: FormBuilder, private router: Router) { }


  goToNextStep() {
    this.submitted = true;
  }

  goToPreviousStep() {
    this.router.navigate(['MentorCreationExpertise']);
  }

  ngOnInit(): void {
  }

  get formControls() { return this.profileForm.controls; }

}
