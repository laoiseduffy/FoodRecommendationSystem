import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Recipe } from '../model/meal';
import { RecipeService } from '../service/recipe-service.service';

@Component({
  selector: 'app-recipe-info',
  templateUrl: './recipe-info.component.html',
  styleUrls: ['./recipe-info.component.css']
})
export class RecipeInfoComponent implements OnInit {

  recipe;
  recipes: Recipe[];

  constructor(private route: ActivatedRoute, private recipeService: RecipeService) {

  }

  ngOnInit() {
    this.getRecipe();
    console.log("Here");
    this.recipeService.getRecipeList().subscribe(data => {
      this.recipes = data;
     });
  }

  getRecipe(): void {
    const recipeIdFromRoute = this.route.snapshot.paramMap.get('mealid');
    console.log(recipeIdFromRoute);
  }

}
