import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {PriceDetails} from '../model/price-details.model';
import {ItemDetails} from '../model/item-details.model';
import {ItemDetailService} from '../service/item-detail.service';
import {PriceDetailService} from '../service/price-detail.service';
import {NgForm} from '@angular/forms';
import {take} from 'rxjs/operators';

@Component({
  selector: 'app-price-calculator',
  templateUrl: './price-calculator.component.html',
  styleUrls: ['./price-calculator.component.css']
})
export class PriceCalculatorComponent implements OnInit {

  @ViewChild('priceCalculatorForm', {read: 0, static: true}) priceCalculatorForm: NgForm;
  @Input() priceDetails: PriceDetails;
  itemList: ItemDetails[];
  unitTypes: any[];

  constructor(private itemDetailService: ItemDetailService,
              private priceDetailService: PriceDetailService) { }

  ngOnInit(): void {
    if (this.priceDetails === null || this.priceDetails === undefined) {
      this.priceDetails = new PriceDetails();
    }

    this.itemDetailService.getAllItemDetails().pipe(take(1)).subscribe(value => {
      this.itemList = value;
    });

    this.priceDetailService.getUnitTypes().pipe(take(1)).subscribe((value: any[]) => {
      this.unitTypes = value;
    });
  }

  isFormValid(): boolean {
    console.log('price', this.priceDetails);
    if (this.priceDetails && this.priceDetails.itemDetailsSeq && this.priceDetails.unitType && this.priceDetails.unitCount) {
      return true;
    }
  }

  calculatePrice(): void{
    if (this.priceDetails.discountInPrice || this.priceDetails.finalPrice ){
      this.priceDetails.discountInPrice = null;
      this.priceDetails.finalPrice = null;
    }
    this.priceDetailService.getPriceDetails(this.priceDetails).pipe(take(1)).subscribe(value => {
      this.priceDetails = value;
    });
  }
}
