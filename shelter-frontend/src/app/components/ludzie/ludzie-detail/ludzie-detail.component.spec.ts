import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LudzieDetailComponent } from './ludzie-detail.component';

describe('LudzieDetailComponent', () => {
  let component: LudzieDetailComponent;
  let fixture: ComponentFixture<LudzieDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LudzieDetailComponent]
    });
    fixture = TestBed.createComponent(LudzieDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
