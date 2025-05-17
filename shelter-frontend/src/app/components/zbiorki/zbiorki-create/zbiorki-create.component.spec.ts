import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZbiorkiCreateComponent } from './zbiorki-create.component';

describe('ZbiorkiCreateComponent', () => {
  let component: ZbiorkiCreateComponent;
  let fixture: ComponentFixture<ZbiorkiCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZbiorkiCreateComponent]
    });
    fixture = TestBed.createComponent(ZbiorkiCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
