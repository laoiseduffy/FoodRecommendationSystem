import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { RecipeInfoComponent } from './recipe-info.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { ActivatedRoute } from '@angular/router';

describe('RecipeInfoComponent', () => {
  let component: RecipeInfoComponent;
  let fixture: ComponentFixture<RecipeInfoComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipe: Observable<Recipe>;
  let id: number = 1;
  let activatedRoute: ActivatedRoute;
  let activatedRouteStub: Partial<ActivatedRoute>;

  beforeEach(() => {
    recipeServiceStub = {
      findRecipeById(id): Observable<Recipe> { return observableRecipe; }
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
});
