import { TestBed } from '@angular/core/testing';

import { CurrentBuildService } from './current-build.service';

describe('CurrentBuildService', () => {
  let service: CurrentBuildService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentBuildService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
