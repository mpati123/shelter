import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZbiorkiComponent } from './zbiorki.component';

describe('ZbiorkiComponent', () => {
  let component: ZbiorkiComponent;
  let fixture: ComponentFixture<ZbiorkiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZbiorkiComponent]
    });
    fixture = TestBed.createComponent(ZbiorkiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
