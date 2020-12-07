import { Component, OnInit } from '@angular/core';
import { Recipe } from '../model/meal';
import { RecipeService } from '../service/recipe-service.service';
import { Router } from '@angular/router';

@Component({
            selector: 'app-recipe-list',
            templateUrl: './recipe-list.component.html',
            styleUrls: ['./recipe-list.component.css']
          })
export class RecipeListComponent implements OnInit {

  recipes: Recipe[];

  constructor(private recipeService: RecipeService, private router: Router) { }

  ngOnInit() {
    console.log("Here");
    this.recipeService.findAll().subscribe(data => {
      this.recipes = data;
     });
  }

  gotoInfo() {
      this.router.navigate(['/recipe-info']);
    }

}