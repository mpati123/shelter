import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FakturyListComponent } from './faktury-list.component';

describe('FakturyListComponent', () => {
  let component: FakturyListComponent;
  let fixture: ComponentFixture<FakturyListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FakturyListComponent]
    });
    fixture = TestBed.createComponent(FakturyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
