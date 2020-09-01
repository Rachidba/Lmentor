import { Component, OnInit } from '@angular/core';
import { MentorItem } from 'src/app/models/MentorItem.model';
import { MentorService } from 'src/app/services/mentors/mentor.service';
import { CategoryService } from 'src/app/services/categories/category.service';
import { Category } from 'src/app/models/Category.model';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  categories: Category[];
  allMentors: MentorItem[];
  filtredMentors: MentorItem[];

  constructor(private mentorService: MentorService, private categoryService: CategoryService) { }

  searchCategory: string;
  searchText: string;

  ngOnInit(): void {
    this.getMentors();
    this.getCategories();
  }

  private getMentors() : void {
    this.mentorService.getMentorsItems()
    .subscribe(
      res => {
        this.allMentors = res;
        this.filtredMentors = res;
      }, 
      err => {
        console.log('Error: ', err)
      }
    );
  }

  private getCategories(): void {
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

  public onSearch(): void {
    let tempMentors = this.allMentors;
    if (this.searchCategory != 'all')
      tempMentors = tempMentors.filter(mentor => mentor.expertiseAreas[0]?.categoryName === this.searchCategory);
    // if (this.searchText != null) {
    //   tempMentors = tempMentors.filter(mentor => mentor.expertiseAreas.map(a => { return a.subcategoryName.toLowerCase }).includes(this.searchText.toLowerCase));
    // }
    this.filtredMentors = tempMentors;
  }
}
