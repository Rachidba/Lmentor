import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MentorProfileVo } from 'src/app/models/MentorProfileVo';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { MentorDetails } from 'src/app/models/MentorDetails.model';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  private backendUrl = environment.apiUrl + '/mentors';

  constructor(private httpClient: HttpClient) { }

  public completeCreation(mentorProfile: MentorProfileVo): Observable<any> {
    return this.httpClient.post(this.backendUrl, mentorProfile)
    .pipe(
      map(
        result => {
          localStorage.setItem('isProfileCompleted', 'true');
          return result;
        }, 
        err => {
          return err
        }
      )
    );
  }

  public getMentorsItems(): Observable<any> {
    return this.httpClient.get(this.backendUrl)
      .pipe(
        map(
          result => {
            return result;
          }, 
          err => {
            return err
          }
        )
      );
  }

  public getMentorDetails(profileId: number): Observable<MentorDetails> {
    return this.httpClient.get<MentorDetails>(this.backendUrl + '/' + profileId)
      .pipe(
        map(
          result => {
            return result;
          }, 
          err => {
            return err
          }
        )
      );
  }
}
