import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracownicyDetailComponent } from './pracownicy-detail.component';

describe('PracownicyDetailComponent', () => {
  let component: PracownicyDetailComponent;
  let fixture: ComponentFixture<PracownicyDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PracownicyDetailComponent]
    });
    fixture = TestBed.createComponent(PracownicyDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
