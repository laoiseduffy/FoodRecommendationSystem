import { TestBed } from '@angular/core/testing';
import { RecipeService } from './recipe-service.service';

describe('RecipeService', () => {
  let service: RecipeService;
  let httpClientSpy: { get: jasmine.Spy };

  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    service = new RecipeService(httpClientSpy as any);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
