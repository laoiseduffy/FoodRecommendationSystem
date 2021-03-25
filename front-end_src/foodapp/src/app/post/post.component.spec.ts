import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RecipeService } from '../service/recipe-service.service';
import { PostComponent } from './post.component';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';

describe('PostComponent', () => {
  let component: PostComponent;
  let fixture: ComponentFixture<PostComponent>;
  let recipeService: RecipeService;
  let recipeServiceStub: Partial<RecipeService>;
  let observableRecipeList: Observable<Recipe[]>;

  beforeEach(() => {
    recipeServiceStub = {
      getPostRecipes: () => observableRecipeList
    };
    TestBed.configureTestingModule({
      declarations: [ PostComponent ],
      providers: [{ provide: RecipeService, useValue: recipeServiceStub }],
    });
    fixture = TestBed.createComponent(PostComponent);
    component = fixture.componentInstance;
    recipeService = TestBed.inject(RecipeService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
