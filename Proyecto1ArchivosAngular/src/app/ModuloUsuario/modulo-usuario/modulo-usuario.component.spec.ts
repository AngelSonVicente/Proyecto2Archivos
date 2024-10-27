import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuloUsuarioComponent } from './modulo-usuario.component';

describe('ModuloUsuarioComponent', () => {
  let component: ModuloUsuarioComponent;
  let fixture: ComponentFixture<ModuloUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModuloUsuarioComponent]
    });
    fixture = TestBed.createComponent(ModuloUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
