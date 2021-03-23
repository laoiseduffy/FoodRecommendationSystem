import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../service/recipe-service.service';
import { Recipe } from '../model/meal';

@Component({
  selector: 'app-healthy',
  templateUrl: './healthy.component.html',
  styleUrls: ['./healthy.component.css']
})
export class HealthyComponent implements OnInit {

  preRecipes: Recipe[];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.recipeService.getHealthyRecipes().subscribe(data => {
      this.preRecipes = data;
    });
  }

  reload() {
    window.location.reload();
  }

}
