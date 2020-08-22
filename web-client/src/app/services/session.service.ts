import { Injectable } from '@angular/core';
import * as moment from 'moment';

@Injectable({
    providedIn: 'root'
  })
export class SessionService {
    public setSession(authResult) {
        if (authResult.status == 200) {
          const id_token = authResult.headers.get("Authorization");
          const expires_at = authResult.headers.get("expiresAt");
          const expiresAt = moment().add(expires_at, 'second');
          localStorage.setItem('id_token', id_token);
          localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()));
        }
    }

    public removeSession() {
        localStorage.removeItem("id_token");
        localStorage.removeItem("expires_at");
    }

    public isLoggedIn() {
        return moment().isBefore(this.getExpiration());
    }

    getExpiration() {
        const expiration = localStorage.getItem("expires_at");
        const expiresAt = JSON.parse(expiration);
        return moment(expiresAt);
    }

}