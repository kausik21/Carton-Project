import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpService} from '../util/HttpService';
import {HttpClient} from '@angular/common/http';
import {PriceDetails} from '../model/price-details.model';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PriceDetailService {

  constructor(private http: HttpClient) { }

  getPriceDetails(priceDetails: PriceDetails): Observable<PriceDetails> {
    return this.http.post(HttpService.SERVICE_PATH + 'priceCalculator/calculatePrice', priceDetails, {headers: null})
      .pipe(map(response => response as PriceDetails));
  }

  getUnitTypes(): Observable<any[]> {
    return this.http.get(HttpService.SERVICE_PATH + 'priceCalculator/getUnitTypes', {headers: null})
      .pipe(map(response => response as any[]));
  }
}
