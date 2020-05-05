import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteSubactividadesComponent } from './delete-subactividades.component';

describe('DeleteSubactividadesComponent', () => {
  let component: DeleteSubactividadesComponent;
  let fixture: ComponentFixture<DeleteSubactividadesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteSubactividadesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteSubactividadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
