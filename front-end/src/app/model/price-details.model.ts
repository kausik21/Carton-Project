import {ItemDetails} from './item-details.model';

export class PriceDetails {
  priceDetailsSeq: number;
  itemDetailsSeq: number;
  unitType: number;
  unitCount: number;
  price: number;
  discount: number;
  finalPrice: number;

  itemDetails: ItemDetails;
  discountInPrice: number;
}
