import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyComponent } from './healthy.component';
import { RecipeService } from '../service/recipe-service.service';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';

describe('HealthyComponent', () => {
  let component: HealthyComponent;
  let fixture: ComponentFixture<HealthyComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;

  beforeEach(() => {
    recipeServiceStub = {
      getHealthyRecipes: () => observableRecipeList
    };
    TestBed.configureTestingModule({
      declarations: [ HealthyComponent ],
      providers: [ { provide: RecipeService, useValue: recipeServiceStub } ],
    });
    fixture = TestBed.createComponent(HealthyComponent);
    component = fixture.componentInstance;
    recipeService = TestBed.inject(RecipeService);
  })

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
