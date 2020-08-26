import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject  } from 'rxjs';
import { Observable } from 'rxjs';
import { RegisterDTO } from '../models/RegisterDTO.model';
import { LoginDTO } from '../models/LoginDTO.model';
import { SessionService } from './session.service';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  authChange = new Subject<boolean>();

  private backendUrl = environment.apiUrl;

  constructor(private httpClient: HttpClient, private sessionService: SessionService) { }

  public register(registerDto: RegisterDTO): Observable<any> {
    return this.httpClient.post(this.backendUrl + '/register', registerDto)
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
  public login(loginDto: LoginDTO): Observable<any>  {
    return this.httpClient.post(this.backendUrl + '/login', loginDto)
      .pipe(
        map( 
          result => {
            this.sessionService.setSession(result);
            return result;
          }, 
          err => {
            return err
          }
        )
    );
  }

  public logout() {
    this.authChange.next(false);
  }

  public isAuth() {
    return false;
  }
}
