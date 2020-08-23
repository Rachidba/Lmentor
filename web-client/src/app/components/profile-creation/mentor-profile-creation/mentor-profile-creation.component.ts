import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Category } from 'src/app/models/Category.model';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-mentor-profile-creation',
  templateUrl: './mentor-profile-creation.component.html',
  styleUrls: ['./mentor-profile-creation.component.css']
})
export class MentorProfileCreationComponent implements OnInit {
  categories: Category[];
  
  isLinear = false;
  personalInfosFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  professionalInfosFormGroup: FormGroup;
  educationInfosFormGroup: FormGroup;
  expertiseInfosFormGroup: FormGroup;
  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    // this.firstFormGroup = this._formBuilder.group({
    //   firstCtrl: ['', Validators.required]
    // });
    // this.secondFormGroup = this._formBuilder.group({
    //   secondCtrl: ['', Validators.required]
    // });
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

}
