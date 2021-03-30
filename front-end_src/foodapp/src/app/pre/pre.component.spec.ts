import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { PreComponent } from './pre.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { of } from 'rxjs';

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
//     recipeService = fixture.debugElement.injector.get(RecipeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should reload once the reload button is clicked', async(() => {
    spyOn(component, 'reload');
    spyOn(recipeServiceStub, 'getPreRecipes').and.returnValue(of(null));
    fixture.detectChanges();
    const buttonElement: HTMLElement = fixture.nativeElement;
    const button = buttonElement.querySelector('button');
    expect(button.textContent).toEqual('Reload');
    button.click();
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      expect(component.reload).toHaveBeenCalled();
    })
  }));

});
