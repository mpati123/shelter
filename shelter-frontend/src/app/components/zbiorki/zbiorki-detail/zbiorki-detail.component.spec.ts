import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZbiorkiDetailComponent } from './zbiorki-detail.component';

describe('ZbiorkiDetailComponent', () => {
  let component: ZbiorkiDetailComponent;
  let fixture: ComponentFixture<ZbiorkiDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZbiorkiDetailComponent]
    });
    fixture = TestBed.createComponent(ZbiorkiDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
