import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearArchivoSubCarpetaComponent } from './crear-archivo-sub-carpeta.component';

describe('CrearArchivoSubCarpetaComponent', () => {
  let component: CrearArchivoSubCarpetaComponent;
  let fixture: ComponentFixture<CrearArchivoSubCarpetaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CrearArchivoSubCarpetaComponent]
    });
    fixture = TestBed.createComponent(CrearArchivoSubCarpetaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
