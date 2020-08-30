import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable()
export class AppSettingsService {

   constructor(private http: HttpClient) {
    }

    public getCities(): Observable<any> {
        return this.http.get("/assets/cities.json");
    }
    public getYears(): Observable<any> {
        return this.http.get("/assets/years.json");
    }
}