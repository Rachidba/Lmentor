import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterDto } from '../models/vo/RegisterVo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private backendUrl = "http://localhost:8080/api/register";

  constructor(private httpClient: HttpClient) { }

  public register(registerDto: RegisterDto): Observable<any> {
    return this.httpClient.post(this.backendUrl, registerDto);
  }
}
