import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FakturyCreateComponent } from './faktury-create.component';

describe('FakturyCreateComponent', () => {
  let component: FakturyCreateComponent;
  let fixture: ComponentFixture<FakturyCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FakturyCreateComponent]
    });
    fixture = TestBed.createComponent(FakturyCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
