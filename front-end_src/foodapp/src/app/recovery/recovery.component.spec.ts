import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { RecoveryComponent } from './recovery.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { of } from 'rxjs';

describe('RecoveryComponent', () => {
  let component: RecoveryComponent;
  let fixture: ComponentFixture<RecoveryComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;

  beforeEach(() => {
    recipeServiceStub = {
      getRecoveryRecipes: () => observableRecipeList
    };
    TestBed.configureTestingModule({
      declarations: [ RecoveryComponent ],
      providers: [{ provide: RecipeService, useValue: recipeServiceStub }],
    });
    fixture = TestBed.createComponent(RecoveryComponent);
    component = fixture.componentInstance;
    recipeService = TestBed.inject(RecipeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should reload once the reload button is clicked', async(() => {
    spyOn(component, 'reload');
    spyOn(recipeServiceStub, 'getRecoveryRecipes').and.returnValue(of(null));
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
