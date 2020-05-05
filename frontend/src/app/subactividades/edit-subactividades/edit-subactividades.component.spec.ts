import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSubactividadesComponent } from './edit-subactividades.component';

describe('EditSubactividadesComponent', () => {
  let component: EditSubactividadesComponent;
  let fixture: ComponentFixture<EditSubactividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSubactividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSubactividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
