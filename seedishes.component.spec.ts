import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeedishesComponent } from './seedishes.component';

describe('SeedishesComponent', () => {
  let component: SeedishesComponent;
  let fixture: ComponentFixture<SeedishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeedishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeedishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
