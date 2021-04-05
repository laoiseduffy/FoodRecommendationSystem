import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { RecipeInfoComponent } from './recipe-info/recipe-info.component';
import { PreComponent } from './pre/pre.component';
import { PostComponent } from './post/post.component';
import { RecoveryComponent } from './recovery/recovery.component';
import { HealthyComponent } from './healthy/healthy.component';
import { SearchComponent } from './search/search.component';
import { HelpComponent } from './help/help.component';

const routes: Routes = [
  { path: 'recipe-info/:mealid', component: RecipeInfoComponent },
  { path: '', component: HomeComponent },
  { path: 'pre', component: PreComponent },
  { path: 'post', component: PostComponent },
  { path: 'recovery', component: RecoveryComponent },
  { path: 'healthy', component: HealthyComponent },
  { path: 'search', component: SearchComponent },
  { path: 'help', component: HelpComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
     scrollPositionRestoration: "enabled",
     scrollOffset: [0,0],
     anchorScrolling: "enabled"
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
