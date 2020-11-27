import { Component, OnInit } from '@angular/core';
import { Recipe } from '../model/meal';
import { RecipeService } from '../service/recipe-service.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  //recipes: Recipe[];
  recipes: Recipe[];

  nums: number[];

//private recipeService: RecipeService
  constructor(private recipeService: RecipeService) { this.nums = [1,2,3,4,5]; }

  ngOnInit() {
    console.log("Here");
    this.recipeService.findAll().subscribe(data => {
      this.recipes = data;
     });
  }

}
