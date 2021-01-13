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

  //https://localhost:4200

  public findAll(): Observable<Recipe[]> {
    this.observableRecipeList = this.http.get<Recipe[]>(this.recipeUrl);
    console.log(this.observableRecipeList);
    console.log(this.recipeList);
    return this.observableRecipeList;
  }

  public save(recipe: Recipe) {
    return this.http.post<Recipe>(this.recipeUrl, recipe);
  }
}

//
//       .map(res => {
//         return res.json().results.map(recipe => {
//           return new Recipe(recipe.mealid, recipe.carbs, recipe.cookTime,
//             recipe.description, recipe.fat, recipe.fibre, recipe.image_url,
//             recipe.ingredients, recipe.kcal, recipe.keywords, recipe.method,
//             recipe.prepTime, recipe.protein, recipe.rating, recipe.salt,
//             recipe.saturates, recipe.sugars, recipe.title);
//         });
//       });
