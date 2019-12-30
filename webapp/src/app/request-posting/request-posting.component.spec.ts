import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestPostingComponent } from './request-posting.component';

describe('RequestPostingComponent', () => {
  let component: RequestPostingComponent;
  let fixture: ComponentFixture<RequestPostingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestPostingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestPostingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
