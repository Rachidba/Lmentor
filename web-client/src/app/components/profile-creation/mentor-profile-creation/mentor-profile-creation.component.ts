import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Category } from 'src/app/models/Category.model';
import { GenderType } from 'src/app/models/GenderType';
import { MentorProfileVo } from 'src/app/models/MentorProfileVo';
import { Subcategory } from 'src/app/models/Subcategory.model';
import { CategoryService } from 'src/app/services/category.service';
import { MentorService } from 'src/app/services/mentor/mentor.service';

@Component({
  selector: 'app-mentor-profile-creation',
  templateUrl: './mentor-profile-creation.component.html',
  styleUrls: ['./mentor-profile-creation.component.css']
})
export class MentorProfileCreationComponent implements OnInit {
  categories: Category[];
  isLinear: boolean = false;
  personalInfosFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  professionalInfosFormGroup: FormGroup;
  educationInfosFormGroup: FormGroup;
  expertiseInfosFormGroup: FormGroup;
  subcategories: Subcategory[];


  constructor(private categoryService: CategoryService, private mentorService: MentorService, private formbuilder: FormBuilder) { }

  ngOnInit(): void {
    this.personalInfosFormGroup = this.formbuilder.group({
      fName: ['', Validators.required],
      lName: ['', Validators.required],
      phoneNumber: [''],
      city: [''],
      title: ['', Validators.required],
      description: ['', Validators.required],
    });

    this.educationInfosFormGroup = this.formbuilder.group({
      school: ['', Validators.required],
      degree: ['', Validators.required],
      startYear: ['', Validators.required],
      endYear: ['', Validators.required],
      description: ['']
    });

    this.professionalInfosFormGroup = this.formbuilder.group({
      companyName: [''],
      role: [''],
      startYear: [''],
      endYear: [''],
      description: [''],
      linkedinUrl: ['']
    });

    this.expertiseInfosFormGroup = this.formbuilder.group({
      category: ['', Validators.required],
      subcategories: ['', Validators.required]
    });

    this.getCategories();
  }
  getCategories() {
    this.categoryService.getCategories()
    .subscribe(
      res => {
        this.categories = res;
      }, 
      err => {
        console.log('Error: ', err)
      }
    );
  }
  get personalFormControls() { return this.personalInfosFormGroup.controls; }
  get professionalFormControls() { return this.professionalInfosFormGroup.controls; }
  get educationFormControls() { return this.educationInfosFormGroup.controls; }
  get experienceFormControls() { return this.expertiseInfosFormGroup.controls; }

  onSubmitForm() {
    if(this.personalInfosFormGroup.invalid
      || this.educationInfosFormGroup.invalid
      || this.professionalInfosFormGroup.invalid
      || this.expertiseInfosFormGroup.invalid)
      return;
      let mentorProfile = this.buildMentorProfile();
    this.mentorService.completeCreation(mentorProfile);

    this.mentorService.completeCreation(mentorProfile).subscribe(
      res => {
        console.log('Res: ', res)
      }, 
      err => {
        console.log('Error: ', err)
      }
    );
  }

  changeCategory(value) {
    console.log(value);
    let category = this.categories.filter(category => category.id == value);
    this.subcategories = category[0].subcategories;
  }

  private buildMentorProfile() : MentorProfileVo {
    let education = {
      school: this.educationFormControls.school.value,
      degree: this.educationFormControls.degree.value,
      fieldOfStudy: "",
      startYear: this.educationFormControls.startYear.value,
      endYear: this.educationFormControls.endYear.value,
      description: this.educationFormControls.description.value
    };
    let experience = {
      companyName: this.professionalFormControls.companyName.value,
      role: this.professionalFormControls.role.value,
      startYear: this.professionalFormControls.startYear.value,
      startMonth: -1,
      endYear: this.professionalFormControls.endYear.value,
      endMonth: -1,
      description: this.professionalFormControls.description.value
    };
    let subcategories = new Set<number>();
    subcategories.add(1).add(2);
    return new MentorProfileVo(
      GenderType.GENDER_OTHER,
      this.personalFormControls.fName.value,
      this.personalFormControls.lName.value,
      null,
      this.personalFormControls.phoneNumber.value,
      this.personalFormControls.title.value,
      this.personalFormControls.description.value,
      this.personalFormControls.city.value,
      subcategories,
      education,
      experience
    )
  }
}
