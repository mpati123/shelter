import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeczniceCreateComponent } from './lecznice-create.component';

describe('LeczniceCreateComponent', () => {
  let component: LeczniceCreateComponent;
  let fixture: ComponentFixture<LeczniceCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LeczniceCreateComponent]
    });
    fixture = TestBed.createComponent(LeczniceCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
