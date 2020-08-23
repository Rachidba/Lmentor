import { Component, OnInit, Input } from '@angular/core';
import { MentorItem } from 'src/app/models/MentorItem.model';

@Component({
  selector: 'app-mentor-items',
  templateUrl: './mentor-item.component.html',
  styleUrls: ['./mentor-item.component.css']
})
export class MentorItemComponent implements OnInit {

  @Input() mentors: Set<MentorItem>;
  constructor() { }

  ngOnInit(): void {
  }

}
