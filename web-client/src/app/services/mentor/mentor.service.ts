import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MentorProfileVo } from 'src/app/models/MentorProfileVo';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  private backendUrl = "http://161.97.98.232:8080/api/v1/mentors";

  constructor(private httpClient: HttpClient) { }

  public completeCreation(mentorCreationDto: MentorProfileVo): Observable<any> {
    return this.httpClient.post(this.backendUrl, mentorCreationDto);
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
