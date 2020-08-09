import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MentorProfileVo } from 'src/app/models/vo/MentorProfileVo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MentorService {

  private backendUrl = "http://localhost:8080/api/mentor";

  constructor(private httpClient: HttpClient) { }

  public completeCreation(mentorCreationDto: MentorProfileVo): Observable<any> {
    return this.httpClient.post(this.backendUrl, mentorCreationDto);
  }
}
