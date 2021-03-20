import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import { HomeComponent } from './home/home.component'
import { RecipeInfoComponent } from './recipe-info/recipe-info.component';
import { PreComponent } from './pre/pre.component';

const routes: Routes = [
  { path: 'recipes', component: RecipeListComponent, },
  { path: 'addrecipe', component: RecipeFormComponent },
  { path: 'recipe-info/:mealid', component: RecipeInfoComponent },
  { path: '', component: HomeComponent },
  { path: 'pre', component: PreComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
