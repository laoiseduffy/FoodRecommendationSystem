import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import { RecipeService } from './service/recipe-service.service';
import { RecipeInfoComponent } from './recipe-info/recipe-info.component';

@NgModule({
  declarations: [
    AppComponent,
    RecipeListComponent,
    RecipeFormComponent,
    RecipeInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

