import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearSubCarpetaRaizComponent } from './crear-sub-carpeta-raiz.component';

describe('CrearSubCarpetaRaizComponent', () => {
  let component: CrearSubCarpetaRaizComponent;
  let fixture: ComponentFixture<CrearSubCarpetaRaizComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CrearSubCarpetaRaizComponent]
    });
    fixture = TestBed.createComponent(CrearSubCarpetaRaizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
