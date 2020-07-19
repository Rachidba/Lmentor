import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mentor-creation-expertise',
  templateUrl: './mentor-creation-expertise.component.html',
  styleUrls: ['./mentor-creation-expertise.component.css']
})
export class MentorCreationExpertiseComponent implements OnInit {
  jobs: String[] = [
    "Salarie",
    "Etudiant",
    "Professeur",
    "En recherche d'emploi",
    "Autre"
  ];
  title = "Personal informations";
  submitted = false;
  expertiseForm = this.formBuilder.group(
    {
      job: [null, Validators.required],
      expertiseField: [null, [Validators.required]]
    }, 
    {
      updateOn: 'blur'
    }
  );

  constructor(private formBuilder: FormBuilder, private router: Router) { }

  goToNextStep() {
    this.submitted = true;
    this.router.navigate(['MentorCreationProfile']);
  }

  goToPreviousStep() {
    this.router.navigate(['MentorCreationPersonal'])
  }
  get formControls() { return this.expertiseForm.controls; }

  ngOnInit(): void {
  }

}
