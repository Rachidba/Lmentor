import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    private backendUrl = "http://161.97.98.232:8080/api/v1/categories";

    constructor(private httpClient: HttpClient) { }

    public getCategories(): Observable<any> {
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