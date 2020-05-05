import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CamDepDocentesComponent } from './cam-dep-docentes.component';

describe('CamDepDocentesComponent', () => {
  let component: CamDepDocentesComponent;
  let fixture: ComponentFixture<CamDepDocentesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CamDepDocentesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CamDepDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
