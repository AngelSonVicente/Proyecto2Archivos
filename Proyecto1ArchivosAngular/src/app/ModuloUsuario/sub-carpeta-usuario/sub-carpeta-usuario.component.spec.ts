import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubCarpetaUsuarioComponent } from './sub-carpeta-usuario.component';

describe('SubCarpetaUsuarioComponent', () => {
  let component: SubCarpetaUsuarioComponent;
  let fixture: ComponentFixture<SubCarpetaUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SubCarpetaUsuarioComponent]
    });
    fixture = TestBed.createComponent(SubCarpetaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
