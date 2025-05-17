import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FakturyDetailComponent } from './faktury-detail.component';

describe('FakturyDetailComponent', () => {
  let component: FakturyDetailComponent;
  let fixture: ComponentFixture<FakturyDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FakturyDetailComponent]
    });
    fixture = TestBed.createComponent(FakturyDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
