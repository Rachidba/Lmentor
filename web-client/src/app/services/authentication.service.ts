import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject  } from 'rxjs';
import { Observable } from 'rxjs';
import { RegisterDTO } from '../models/RegisterDTO.model';
import { LoginDTO } from '../models/LoginDTO.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  authChange = new Subject<boolean>();
  private backendUrl = "http://localhost:8080/api/register";

  constructor(private httpClient: HttpClient) { }

  public register(registerDto: RegisterDTO): Observable<any> {

    return this.httpClient.post(this.backendUrl, registerDto);
  }
  public login(loginDto: LoginDTO) {
    this.authChange.next(true);
    return null;
  }

  public logout() {
    this.authChange.next(false);
  }

  public isAuth() {
    return false;
  }
  
}
