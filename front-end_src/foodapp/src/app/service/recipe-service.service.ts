import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal'
import 'rxjs/add/operator/map';

@Injectable()
export class RecipeService {

  private recipeUrl: string;
  recipeList: Recipe[];
  observableRecipeList: Observable<Recipe[]>;
  selectedRecipe: Recipe;

  constructor(private http: HttpClient) {
    this.recipeUrl = 'http://localhost:8080';
  }

  public findAll(): Observable<Recipe[]> {
    this.observableRecipeList = this.http.get<Recipe[]>(this.recipeUrl + '/recipes');
    console.log("Fetching from db");
    console.log(this.observableRecipeList);
    return this.observableRecipeList;
  }

  public getRecipeList(): Observable<Recipe[]> {
    return this.observableRecipeList;
  }

  public findRecipeById(mealId: number): Observable<Recipe> {
    console.log(this.recipeUrl + `/recipes/${mealId}`);
    return this.http.get<Recipe>(this.recipeUrl + `/recipes/${mealId}`);
  }

  public getPreRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl + '/prerecipes');
  }

  public getPostRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl + '/postrecipes');
  }

  public getRecoveryRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl + '/recoveryrecipes');
  }

  public getHealthyRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl + '/healthyrecipes');
  }

  public getByKeyword(word: string): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl + `/keyword/${word}`);
  }

  public save(recipe: Recipe) {
    return this.http.post<Recipe>(this.recipeUrl, recipe);
  }
}
