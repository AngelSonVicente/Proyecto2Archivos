import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearArchivoRaizComponent } from './crear-archivo-raiz.component';

describe('CrearArchivoRaizComponent', () => {
  let component: CrearArchivoRaizComponent;
  let fixture: ComponentFixture<CrearArchivoRaizComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CrearArchivoRaizComponent]
    });
    fixture = TestBed.createComponent(CrearArchivoRaizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
