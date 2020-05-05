import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSubactividadesComponent } from './add-subactividades.component';

describe('AddSubactividadesComponent', () => {
  let component: AddSubactividadesComponent;
  let fixture: ComponentFixture<AddSubactividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSubactividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSubactividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
