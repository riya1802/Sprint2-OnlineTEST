import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallQuestionComponent } from './viewall-question.component';

describe('ViewallQuestionComponent', () => {
  let component: ViewallQuestionComponent;
  let fixture: ComponentFixture<ViewallQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewallQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewallQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
