import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatunekDetailComponent } from './gatunek-detail.component';

describe('GatunekDetailComponent', () => {
  let component: GatunekDetailComponent;
  let fixture: ComponentFixture<GatunekDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GatunekDetailComponent]
    });
    fixture = TestBed.createComponent(GatunekDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
