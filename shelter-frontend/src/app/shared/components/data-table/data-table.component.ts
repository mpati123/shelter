import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent {
  @Input() displayedColumns: string[] = [];
  @Input() dataSource: any[] = [];
  @Input() columnMappings: { [key: string]: (element: any) => string } = {};


  @Output() detailsClicked = new EventEmitter<number>();
  @Output() deleteClicked = new EventEmitter<number>();

  get displayedColumnsWithActions(): string[] {
    return this.displayedColumns.includes('actions')
      ? this.displayedColumns
      : [...this.displayedColumns, 'actions'];
  }

  viewDetails(id: number) {
    this.detailsClicked.emit(id);
  }

  delete(id: number) {
    this.deleteClicked.emit(id);
  }
}
