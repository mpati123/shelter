import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LudzieListComponent } from './ludzie-list.component';

describe('LudzieListComponent', () => {
  let component: LudzieListComponent;
  let fixture: ComponentFixture<LudzieListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LudzieListComponent]
    });
    fixture = TestBed.createComponent(LudzieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
