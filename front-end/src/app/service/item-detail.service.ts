import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ItemDetails} from '../model/item-details.model';
import {HttpService} from '../util/HttpService';

@Injectable({
  providedIn: 'root'
})
export class ItemDetailService {

  constructor(private http: HttpClient) { }

  getAllItemDetails(): Observable<ItemDetails[]> {
    return this.http.get<ItemDetails[]>(HttpService.SERVICE_PATH + 'items');
  }

  getItemByID(id: number): Observable<any> {
    return this.http.get(HttpService.SERVICE_PATH + 'items/' + id);
  }

}
