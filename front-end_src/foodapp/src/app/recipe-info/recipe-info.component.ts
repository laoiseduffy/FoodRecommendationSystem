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

  recipe: Recipe;
  mealId: number;

  constructor(private route: ActivatedRoute, private recipeService: RecipeService) {

  }

  ngOnInit() {
    console.log("Here");
    this.mealId = this.getRecipe();
    this.recipeService.findRecipeById(this.mealId).subscribe(data => {
      this.recipe = data;
    });
  }

  getRecipe(): number {
    return Number(this.route.snapshot.paramMap.get('mealid'));
  }

}
