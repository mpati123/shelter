import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatunekCreateComponent } from './gatunek-create.component';

describe('GatunekCreateComponent', () => {
  let component: GatunekCreateComponent;
  let fixture: ComponentFixture<GatunekCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GatunekCreateComponent]
    });
    fixture = TestBed.createComponent(GatunekCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
