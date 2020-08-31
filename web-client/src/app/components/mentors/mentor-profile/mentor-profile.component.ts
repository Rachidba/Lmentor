import { Component, OnInit } from '@angular/core';
import { MentorDetails } from 'src/app/models/MentorDetails.model';
import { MentorService } from 'src/app/services/mentors/mentor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-mentor-profile',
  templateUrl: './mentor-profile.component.html',
  styleUrls: ['./mentor-profile.component.css']
})
export class MentorProfileComponent implements OnInit {
  mentor: MentorDetails; 
  //  = {
  //   profileId: 1,
  //   fullName: 'Rachid BAAZIZ',
  //   phoneNumber: '0745874514',
  //   title: 'Software engineer | Marketing student',
  //   description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
  //   city: 'Casablanca',
  //   isProfileCompleted: true,
  //   expertiseAreas: [
  //     {
  //       id: 1,
  //       subcategoryName: "JAVA",
  //       categoryName: "Programmation"
  //     },
  //     {
  //       id: 3,
  //       subcategoryName: "Angular",
  //       categoryName: "Programmation"
  //     },
  //     {
  //       id: 2,
  //       subcategoryName: "Web programming",
  //       categoryName: "Programmation"
  //     }
  //   ],
  //   educations: [
  //     {
  //       school: "fstm",
  //       degree: 'Master',
  //       fieldOfStudy: null,
  //       startYear: 2016,
  //       endYear: 2019,
  //       description: "Software engineering"
  //     }
  //   ],
  //   experiences: [
  //     {
  //       companyName: 'SG',
  //       role: 'Software engineer',
  //       startYear: 2019,
  //       startMonth: -1,
  //       endYear: -1,
  //       endMonth: -1,
  //       description: 'Lorem epsum'
  //     }
  //   ],
  //   linkedinProfile: 'link'
  // };

  constructor(private mentorsService: MentorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getProfile();
  }

  private getProfile(): void {
    let profileId = this.route.snapshot.paramMap.get('id');
    this.mentorsService.getMentorDetails(Number(profileId))
      .subscribe(res => {
        console.log(res);
        this.mentor = res;
      },
      (err) => {
        this.router.navigate(['/mentors'])
      });
  }
}
