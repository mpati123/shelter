import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZbiorkiListComponent } from './zbiorki-list.component';

describe('ZbiorkiListComponent', () => {
  let component: ZbiorkiListComponent;
  let fixture: ComponentFixture<ZbiorkiListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZbiorkiListComponent]
    });
    fixture = TestBed.createComponent(ZbiorkiListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
