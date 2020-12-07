import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import { RecipeInfoComponent } from './recipe-info/recipe-info.component';

const routes: Routes = [
  {
    path: 'recipes',
    component: RecipeListComponent,
//     children: [
//       {
//         path: 'recipe-info',
//         component: RecipeInfoComponent,
//       },
//     ],
  },
  { path: 'addrecipe', component: RecipeFormComponent },
  { path: 'recipe-info', component: RecipeInfoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }