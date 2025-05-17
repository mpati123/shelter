import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LudzieComponent } from './ludzie.component';

describe('LudzieComponent', () => {
  let component: LudzieComponent;
  let fixture: ComponentFixture<LudzieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LudzieComponent]
    });
    fixture = TestBed.createComponent(LudzieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
