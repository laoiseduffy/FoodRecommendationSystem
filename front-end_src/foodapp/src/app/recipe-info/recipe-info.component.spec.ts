import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { RecipeInfoComponent } from './recipe-info.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

describe('RecipeInfoComponent', () => {
  let component: RecipeInfoComponent;
  let fixture: ComponentFixture<RecipeInfoComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipe: Observable<Recipe>;
  let id: number = 1;
  let activatedRoute: ActivatedRoute;
  let activatedRouteStub: Partial<ActivatedRoute>;
  let recipeExample: Recipe;

  beforeEach(() => {
    recipeExample = {
      mealid: 1,
      carbs: 10,
      cookTime: 60,
      description: 'string',
      fat: 10,
      fibre: 10,
      image_url: 'string',
      ingredients: ['hello', 'hi'],
      kcal: 10,
      keywords: ['hello', 'hi'],
      method: 'string',
      prepTime: 10,
      protein: 10,
      rating: 10,
      salt: 10,
      saturates: 10,
      sugars: 10,
      title: 'Recipe Title',
      proteinPercentage: 10,
      carbsPercentage: 10,
      fatPercentage: 10,
      pre: true,
      post: false,
      recovery: true,
      healthy: false,
    };
    recipeServiceStub = {
      findRecipeById(id): Observable<Recipe> { return of(recipeExample); }
    };
    activatedRouteStub = {
    };
    TestBed.configureTestingModule({
      declarations: [ RecipeInfoComponent ],
      providers: [
        { provide: RecipeService, useValue: recipeServiceStub },
        { provide: ActivatedRoute, useValue: activatedRouteStub },
        ],
    });
    fixture = TestBed.createComponent(RecipeInfoComponent);
    component = fixture.componentInstance;
    recipeService = TestBed.inject(RecipeService);
    activatedRoute = TestBed.inject(ActivatedRoute);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display the title of the recipe', async(() => {
    spyOn(component, 'getRecipe').and.returnValue(1);
    fixture.detectChanges();
    const cookTimeElement: HTMLElement = fixture.nativeElement;
    const cookTimeDiv = cookTimeElement.querySelector('h1.title');
    expect(cookTimeDiv.textContent).toEqual('Recipe Title');
  }));

});
