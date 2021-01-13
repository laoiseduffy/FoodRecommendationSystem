import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Recipe } from '../model/meal';

@Component({
  selector: 'app-recipe-info',
  templateUrl: './recipe-info.component.html',
  styleUrls: ['./recipe-info.component.css']
})
export class RecipeInfoComponent implements OnInit {
  recipe;
  constructor(private route: ActivatedRoute,) {

  }

  ngOnInit() {
    this.getRecipe();
  }

  getRecipe(): void {
    const recipeIdFromRoute = this.route.snapshot.paramMap.get('mealid');
    console.log(recipeIdFromRoute);
  }

}
