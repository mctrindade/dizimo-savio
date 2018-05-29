import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DizimistaEditComponent } from './dizimista-edit.component';

describe('DizimistaEditComponent', () => {
  let component: DizimistaEditComponent;
  let fixture: ComponentFixture<DizimistaEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DizimistaEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DizimistaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
