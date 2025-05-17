import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeczniceDetailComponent } from './lecznice-detail.component';

describe('LeczniceDetailComponent', () => {
  let component: LeczniceDetailComponent;
  let fixture: ComponentFixture<LeczniceDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeczniceDetailComponent]
    });
    fixture = TestBed.createComponent(LeczniceDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
