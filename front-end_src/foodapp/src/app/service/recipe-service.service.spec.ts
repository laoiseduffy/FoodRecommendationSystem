import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RecipeService } from './recipe-service.service';
import { Observable } from 'rxjs/Observable';
import { Recipe } from '../model/meal';
import { AsyncPipe } from '@angular/common';
import {of} from 'rxjs';

describe('RecipeService', () => {
  let service: RecipeService;
  let httpClientSpy: { get: jasmine.Spy };
  let preRecipes: Recipe[];

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new RecipeService(httpClientSpy as any);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call http  client when findRecipeById is called', () => {
    httpClientSpy.get.and.returnValue(of('expectedRecipe'));
    service.findRecipeById(1).subscribe();
    expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
  });

  it('should call http client when getByKeyword is called', () => {
    httpClientSpy.get.and.returnValue(of('recipe'));
    service.getByKeyword('word').subscribe();
    expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
  });

  it('should call http client when getPreRecipes is called', () => {
    httpClientSpy.get.and.returnValue(of('pre recipes'));
    service.getPreRecipes();
    expect(httpClientSpy.get.calls.count()).toBe(1);
  });

  it('should call http client when getPostRecipes is called', () => {
    httpClientSpy.get.and.returnValue(of('post recipes'));
    service.getPostRecipes();
    expect(httpClientSpy.get.calls.count()).toBe(1);
  });

  it('should call http client when getRecoveryRecipes is called', () => {
    httpClientSpy.get.and.returnValue(of('recovery recipes'));
    service.getRecoveryRecipes();
    expect(httpClientSpy.get.calls.count()).toBe(1);
  });

  it('should call http client when getHealthyRecipes is called', () => {
    httpClientSpy.get.and.returnValue(of('healthy recipes'));
    service.getHealthyRecipes();
    expect(httpClientSpy.get.calls.count()).toBe(1);
  });

});
