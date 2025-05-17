import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracownicyCreateComponent } from './pracownicy-create.component';

describe('PracownicyCreateComponent', () => {
  let component: PracownicyCreateComponent;
  let fixture: ComponentFixture<PracownicyCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PracownicyCreateComponent]
    });
    fixture = TestBed.createComponent(PracownicyCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
