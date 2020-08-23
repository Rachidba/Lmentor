import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-mentor-profile-creation',
  templateUrl: './mentor-profile-creation.component.html',
  styleUrls: ['./mentor-profile-creation.component.css']
})
export class MentorProfileCreationComponent implements OnInit {
  isLinear = false;
  personalInfosFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  professionalInfosFormGroup: FormGroup;
  educationInfosFormGroup: FormGroup;
  expertiseInfosFormGroup: FormGroup;
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];


  constructor() { }

  ngOnInit(): void {
    // this.firstFormGroup = this._formBuilder.group({
    //   firstCtrl: ['', Validators.required]
    // });
    // this.secondFormGroup = this._formBuilder.group({
    //   secondCtrl: ['', Validators.required]
    // });
  }

}
