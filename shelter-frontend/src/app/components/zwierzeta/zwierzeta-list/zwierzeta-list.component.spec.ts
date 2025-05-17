import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZwierzetaListComponent } from './zwierzeta-list.component';

describe('ZwierzetaListComponent', () => {
  let component: ZwierzetaListComponent;
  let fixture: ComponentFixture<ZwierzetaListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ZwierzetaListComponent]
    });
    fixture = TestBed.createComponent(ZwierzetaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
