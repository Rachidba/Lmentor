import { Component, OnInit } from '@angular/core';
import { MentorItem } from 'src/app/models/MentorItem.model';
import { MentorService } from 'src/app/services/mentor/mentor.service';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/models/Category.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  categories: Category[];
  mentors: MentorItem[];

  // mentors = [
  //   {
  //     fullName: "Rachid BAAZIZ",
  //     title: "Software engineer",  
  //     description: "This is a description",
  //     expertiseAreas: [
  //       {
  //         id: 2,
  //         subcategoryName: "JAVA",
  //         categoryName: "Programming"
  //       }
  //     ],
  //     profileId: 1
  //   },
  //   {
  //     fullName: "Oumaima DAHHOUM",
  //     title: "Software engineer",  
  //     description: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
  //     expertiseAreas: [
  //       {
  //         id: 2,
  //         subcategoryName: "JAVA",
  //         categoryName: "Programming"
  //       }
  //     ],
  //     profileId: 1
  //   }
  // ]

  constructor(private mentorService: MentorService, private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getMentors();
    this.getCategories();
  }

  getMentors() {
    this.mentorService.getMentorsItems()
    .subscribe(
      res => {
        this.mentors = res;
      }, 
      err => {
        console.log('Error: ', err)
      }
    );
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
