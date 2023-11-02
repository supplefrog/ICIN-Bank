import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckbookComponent } from './checkbook.component';

describe('CheckbookComponent', () => {
  let component: CheckbookComponent;
  let fixture: ComponentFixture<CheckbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckbookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
