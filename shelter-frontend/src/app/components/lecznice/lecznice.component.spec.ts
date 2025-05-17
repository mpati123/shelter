import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeczniceComponent } from './lecznice.component';

describe('LeczniceComponent', () => {
  let component: LeczniceComponent;
  let fixture: ComponentFixture<LeczniceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeczniceComponent]
    });
    fixture = TestBed.createComponent(LeczniceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
