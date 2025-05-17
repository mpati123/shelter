import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZwierzetaCreateComponent } from './zwierzeta-create.component';

describe('ZwierzetaCreateComponent', () => {
  let component: ZwierzetaCreateComponent;
  let fixture: ComponentFixture<ZwierzetaCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZwierzetaCreateComponent]
    });
    fixture = TestBed.createComponent(ZwierzetaCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
