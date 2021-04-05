import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { SearchComponent } from './search.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

describe('SearchComponent', () => {
  let component: SearchComponent;
  let fixture: ComponentFixture<SearchComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;
  let word: string = 'word';
  let recipeExample: Recipe;
  let recipeList: Recipe[];

  beforeEach(() => {
    recipeServiceStub = {
      getByKeyword(word): Observable<Recipe[]> { return observableRecipeList; }
    };
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
    recipeList = [recipeExample];
    TestBed.configureTestingModule({
      declarations: [ SearchComponent ],
      imports: [FormsModule],
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

  it('should search for the inputted keyword', async(() => {
    spyOn(recipeServiceStub, 'getByKeyword').and.returnValue(of(recipeList));
    spyOn(component, 'searchComplete').and.returnValue(null);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      let el = fixture.nativeElement.querySelector('input');
      let button = fixture.nativeElement.querySelector('button');
      el.value = 'chicken';
      el.dispatchEvent(new Event('input'));
      button.click();
      fixture.detectChanges();
      expect(component.word).toBe('chicken');
      expect(recipeServiceStub.getByKeyword).toHaveBeenCalledWith('chicken');
    });
  }));

  it('should display the number of found recipes', async(() => {
    spyOn(recipeServiceStub, 'getByKeyword').and.returnValue(of(recipeList));
    spyOn(component, 'searchComplete').and.callThrough();
    expect(component.hide).toBe(true);
    fixture.detectChanges();
        fixture.whenStable().then(() => {
          let el = fixture.nativeElement.querySelector('input');
          let button = fixture.nativeElement.querySelector('button');
          let results = fixture.nativeElement.querySelector('p.results');
          el.value = 'chicken';
          el.dispatchEvent(new Event('input'));
          button.click();
          fixture.detectChanges();
          expect(component.searchComplete).toHaveBeenCalled();
          expect(component.hide).toBe(false);
          expect(component.total).toBe(1);
          expect(results.textContent).toEqual('showing 1 of 13,700 recipes');
        });
  }));

});
