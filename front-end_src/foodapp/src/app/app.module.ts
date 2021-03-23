import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RecipeService } from './service/recipe-service.service';
import { RecipeInfoComponent } from './recipe-info/recipe-info.component';
import { HomeComponent } from './home/home.component';
import { PreComponent } from './pre/pre.component';
import { PostComponent } from './post/post.component';
import { RecoveryComponent } from './recovery/recovery.component';
import { HealthyComponent } from './healthy/healthy.component';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    RecipeInfoComponent,
    HomeComponent,
    PreComponent,
    PostComponent,
    RecoveryComponent,
    HealthyComponent,
    SearchComponent
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

