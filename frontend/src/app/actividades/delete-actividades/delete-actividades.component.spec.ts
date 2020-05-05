import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteActividadesComponent } from './delete-actividades.component';

describe('DeleteActividadesComponent', () => {
  let component: DeleteActividadesComponent;
  let fixture: ComponentFixture<DeleteActividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteActividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteActividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
