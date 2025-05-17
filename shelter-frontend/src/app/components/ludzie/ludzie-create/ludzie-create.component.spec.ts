import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LudzieCreateComponent } from './ludzie-create.component';

describe('LudzieCreateComponent', () => {
  let component: LudzieCreateComponent;
  let fixture: ComponentFixture<LudzieCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LudzieCreateComponent]
    });
    fixture = TestBed.createComponent(LudzieCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
