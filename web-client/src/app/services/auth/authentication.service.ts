import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject, Observable  } from 'rxjs';
import { RegisterDTO } from 'src/app/models/RegisterDTO.model';
import { LoginDTO } from 'src/app/models/LoginDTO.model';
import { LoginResponse } from 'src/app/models/LoginResponse.model';
import { map, share } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { JwtHelperService } from '@auth0/angular-jwt';
import { RoleType } from 'src/app/models/RoleType';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  authChange = new Subject<boolean>();

  private backendUrl = environment.apiUrl;
  private decoder = new JwtHelperService();
  constructor(private httpClient: HttpClient) { }

  public register(registerDto: RegisterDTO): Observable<any> {
    return this.httpClient.post(this.backendUrl + '/auth/register', registerDto)
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

  public login(loginDto: LoginDTO): Observable<LoginResponse>  {
    return this.httpClient.post<LoginResponse>(this.backendUrl + '/auth/login', loginDto)
      .pipe(
        map( 
          result => {
            localStorage.setItem('refreshToken', result.refreshToken);
            localStorage.setItem('token', result.token);
            localStorage.setItem('profileId', String(result.profileId));
            localStorage.setItem('isProfileCompleted', String(result.isProfileCompleted));
            this.authChange.next(true);
            return result;
          }, 
          err => {
            return err;
          }
        )
    );
  }

  public logToken() : void {
    let token = localStorage.getItem('token');
    console.log(this.decoder.decodeToken(token));
  }

  public getRole() : RoleType {
    if (!this.isAuth) return null;
    let token = localStorage.getItem('token');
    if(token == null) return null;
    let decodedToken = this.decoder.decodeToken(token);
    return decodedToken.scopes[0];
  }

  public isMentor() : boolean {
    let role = this.getRole();
    return (role?.toString() === 'ROLE_MENTOR');
  }

  public logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('refreshToken');
    localStorage.removeItem('profileId');
    localStorage.removeItem('isProfileCompleted');
    this.authChange.next(false);
  }

  public isAuth(): boolean {
    let token = localStorage.getItem('token');
    if (!!token) 
      return !this.decoder.isTokenExpired(token);
    return false;
  }

  public isProfileComleted() : boolean {
    let isProfileComleted = localStorage.getItem('isProfileCompleted');
    if (!!isProfileComleted)
      return isProfileComleted =="true";
    return false;
  }

  refreshToken(): Observable<string> {
    const url = this.backendUrl + '/auth/token';

    return this.httpClient
      .get<LoginResponse>(url)
      .pipe(
        share(), // <========== YOU HAVE TO SHARE THIS OBSERVABLE TO AVOID MULTIPLE REQUEST BEING SENT SIMULTANEOUSLY
        map(
          result => {
            let token = result.token;
            localStorage.setItem('token', token);
            return token;
          }, 
          err => {
            return null;
          }
        )
      );
  }

  getToken(): string {
    const token = localStorage.getItem('token');
    const isTokenExpired = this.decoder.isTokenExpired(token);

    if (!isTokenExpired) {
      return token;
    }

    this.refreshToken().pipe(
      share(), // <========== YOU HAVE TO SHARE THIS OBSERVABLE TO AVOID MULTIPLE REQUEST BEING SENT SIMULTANEOUSLY
      map(
        token => {
          return token;
        }, 
        err => {
          return null;
        }
      )
    );
  }
}
