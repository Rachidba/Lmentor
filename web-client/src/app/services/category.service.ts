import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    private backendUrl = environment.apiUrl + '/categories';

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