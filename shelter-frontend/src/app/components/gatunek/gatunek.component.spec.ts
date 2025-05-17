import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatunekComponent } from './gatunek.component';

describe('GatunekComponent', () => {
  let component: GatunekComponent;
  let fixture: ComponentFixture<GatunekComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GatunekComponent]
    });
    fixture = TestBed.createComponent(GatunekComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
