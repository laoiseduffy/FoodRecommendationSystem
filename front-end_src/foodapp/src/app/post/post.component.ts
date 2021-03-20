import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../service/recipe-service.service';
import { Recipe } from '../model/meal';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  postRecipes: Recipe[];

  constructor(private recipeService: RecipeService) { }

  ngOnInit(): void {
    this.recipeService.getPostRecipes().subscribe(data => {
      this.postRecipes = data;
    });
  }

  reload() {
    window.location.reload();
  }

}
