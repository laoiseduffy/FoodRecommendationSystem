import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyComponent } from './healthy.component';
import { RecipeService } from '../service/recipe-service.service';
import { HttpClient ,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';

class MockRecipeService {
  getHealthyRecipes = 'healthyRecipes';
  recipeUrl = '';
  recipeList = [];
  observableRecipeList = new Observable<Recipe[]>();
  selectedRecipe = new Recipe();
//   http = 'http';
  findRecipeById = 'fake id';
  getPreRecipes = 'fake pre';
  getPostRecipes = 'post fake';
  getRecoveryRecipes = 'recovery fake';
  getByKeyword = 'fake keyword';
  constructor(private http: HttpClient) {}
}

//     const fake =  { getHealthyRecipes: () => 'fake value', private recipeUrl: () => 'url', recipeList: () => 'list',
//                       observableRecipeList: () => 'list2', selectedRecipe: () => 'recipe', http: () => 'http',
//                       findRecipeById: () => 'fake id', getPreRecipes: () => 'fake pre',
//                       getPostRecipes: () => 'post fake', getRecoveryRecipes: () => 'recovery fake',
//                       getByKeyword: () => 'fake keyword'};

describe('HealthyComponent', () => {
  let component: HealthyComponent;
  let fixture: ComponentFixture<HealthyComponent>;
  let recipeService: RecipeService;
//   let http: HttpClient;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
//       declarations: [ HealthyComponent ],
      providers: [
        HealthyComponent,
        { provide: RecipeService, useClass: MockRecipeService }
      ]
    })
    .compileComponents();
    component = TestBed.inject(HealthyComponent);
    recipeService = TestBed.inject(RecipeService);
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    component = new HealthyComponent(new MockRecipeService(new HttpClient(new HttpHandler)));
    expect(component).toBeTruthy();
  });
});
