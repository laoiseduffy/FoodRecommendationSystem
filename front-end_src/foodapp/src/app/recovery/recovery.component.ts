import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../service/recipe-service.service';
import { Recipe } from '../model/meal';

@Component({
  selector: 'app-recovery',
  templateUrl: './recovery.component.html',
  styleUrls: ['./recovery.component.css']
})
export class RecoveryComponent implements OnInit {

  preRecipes: Recipe[];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.recipeService.getRecoveryRecipes().subscribe(data => {
      this.preRecipes = data;
    });
  }

  reload() {
    window.location.reload();
  }

}
