import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  categories = [
    'Programmation',
    'Marketing',
    'Design'
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
