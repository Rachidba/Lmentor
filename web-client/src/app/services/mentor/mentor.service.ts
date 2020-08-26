import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MentorProfileVo } from 'src/app/models/MentorProfileVo';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  private backendUrl = environment.apiUrl + '/mentors';

  constructor(private httpClient: HttpClient) { }

  public completeCreation(mentorProfile: MentorProfileVo): Observable<any> {
    return this.httpClient.post(this.backendUrl, mentorProfile);
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
}
