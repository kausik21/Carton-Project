import {Component, OnInit} from '@angular/core';
import {ItemDetails} from '../model/item-details.model';
import {ItemDetailService} from '../service/item-detail.service';
import {take} from 'rxjs/operators';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {

  itemDetails: ItemDetails[];
  displayedColumns: string[] = ['itemName', 'unitCount', 'description'];
  public dataSource = new MatTableDataSource<ItemDetails>();

  constructor(private itemDetailService: ItemDetailService) { }

  ngOnInit(): void {
    this.itemDetailService.getAllItemDetails().pipe(take(1)).subscribe( (itemDetails: ItemDetails[]) => {
      this.itemDetails = itemDetails;
      console.log('items', this.itemDetails);
      this.dataSource.data = this.itemDetails as ItemDetails[];
    });
  }

}
