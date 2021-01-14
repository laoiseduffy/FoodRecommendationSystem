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

  constructor(private http: HttpClient) {
    this.recipeUrl = 'http://localhost:8080/recipes';
  }

  public findAll(): Observable<Recipe[]> {
    this.observableRecipeList = this.http.get<Recipe[]>(this.recipeUrl);
    console.log("Fetching from db");
    console.log(this.observableRecipeList);
    return this.observableRecipeList;
  }

  public getRecipeList(): Observable<Recipe[]> {
    return this.observableRecipeList;
  }

  public save(recipe: Recipe) {
    return this.http.post<Recipe>(this.recipeUrl, recipe);
  }
}
