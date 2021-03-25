import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { SearchComponent } from './search.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';

describe('SearchComponent', () => {
  let component: SearchComponent;
  let fixture: ComponentFixture<SearchComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;
  let word: string = 'word';

  beforeEach(() => {
    recipeServiceStub = {
      getByKeyword(word): Observable<Recipe[]> { return observableRecipeList; }
    };
    TestBed.configureTestingModule({
      declarations: [ SearchComponent ],
      providers: [ { provide: RecipeService, useValue: recipeServiceStub }],
    });
    fixture = TestBed.createComponent(SearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    recipeService = TestBed.inject(RecipeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
