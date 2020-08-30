import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Category } from 'src/app/models/Category.model';

@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    private backendUrl = environment.apiUrl + '/categories';

    constructor(private httpClient: HttpClient) { }

    public getCategories(): Observable<Category[]> {
      return this.httpClient.get<Category[]>(this.backendUrl)
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