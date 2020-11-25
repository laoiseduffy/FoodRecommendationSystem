import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal'

@Injectable()
export class RecipeService {

  private recipeUrl: string;

  constructor(private http: HttpClient) {
    this.recipeUrl = 'http://localhost:8080/recipes';
  }

  public findAll(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.recipeUrl);
  }

  public save(recipe: Recipe) {
    return this.http.post<Recipe>(this.recipeUrl, recipe);
  }
}
