import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeczniceListComponent } from './lecznice-list.component';

describe('LeczniceListComponent', () => {
  let component: LeczniceListComponent;
  let fixture: ComponentFixture<LeczniceListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeczniceListComponent]
    });
    fixture = TestBed.createComponent(LeczniceListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
