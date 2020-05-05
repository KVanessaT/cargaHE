import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubactividadesComponent } from './subactividades.component';

describe('SubactividadesComponent', () => {
  let component: SubactividadesComponent;
  let fixture: ComponentFixture<SubactividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubactividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubactividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
