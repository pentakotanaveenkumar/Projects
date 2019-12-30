import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonorSlotDetailsComponent } from './donor-slot-details.component';

describe('DonorSlotDetailsComponent', () => {
  let component: DonorSlotDetailsComponent;
  let fixture: ComponentFixture<DonorSlotDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonorSlotDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonorSlotDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
