import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { PreComponent } from './pre.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';

describe('PreComponent', () => {
  let component: PreComponent;
  let fixture: ComponentFixture<PreComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;

  beforeEach(() => {
    recipeServiceStub = {
      getPreRecipes: () => observableRecipeList
    };
    TestBed.configureTestingModule({
      declarations: [ PreComponent ],
      providers: [{ provide: RecipeService, useValue: recipeServiceStub }],
    });
    fixture = TestBed.createComponent(PreComponent);
    component = fixture.componentInstance;
    recipeService = TestBed.inject(RecipeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
