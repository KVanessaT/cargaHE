import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditActividadesComponent } from './edit-actividades.component';

describe('EditActividadesComponent', () => {
  let component: EditActividadesComponent;
  let fixture: ComponentFixture<EditActividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditActividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditActividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
