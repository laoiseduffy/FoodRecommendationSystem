import { Component, OnInit } from '@angular/core';
import { RecipeService } from '../service/recipe-service.service';
import { Recipe } from '../model/meal';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  word: string;
  recipes: Recipe[] = [];
  total: Number;
  hide: boolean = true;

  constructor(private recipeService: RecipeService) {
  }

  ngOnInit(): void {
    this.hide = true;
  }

  search() {
    this.recipeService.getByKeyword(this.word).subscribe(
      data => { this.recipes = data;},
      err => console.error('Observer got an error: ' + err),
      () => this.searchComplete()
    );

  }

  searchComplete() {
    this.total = this.recipes.length;
    this.hide = false;
    console.log(this.hide);
  }


}
