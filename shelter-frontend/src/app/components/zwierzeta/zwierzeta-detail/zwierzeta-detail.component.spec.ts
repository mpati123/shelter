import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZwierzetaDetailComponent } from './zwierzeta-detail.component';

describe('ZwierzetaDetailComponent', () => {
  let component: ZwierzetaDetailComponent;
  let fixture: ComponentFixture<ZwierzetaDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZwierzetaDetailComponent]
    });
    fixture = TestBed.createComponent(ZwierzetaDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
