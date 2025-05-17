import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GatunekListComponent } from './gatunek-list.component';

describe('GatunekListComponent', () => {
  let component: GatunekListComponent;
  let fixture: ComponentFixture<GatunekListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GatunekListComponent]
    });
    fixture = TestBed.createComponent(GatunekListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
