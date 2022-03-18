package com.example.foo;

import javax.inject.Named;

@Named("fake")
public class FakeFooClient implements FooClient {
  @Override
  public FoosResponse getFoos(int page, int limit) {
    return new FoosResponse("fakefoo1, fakefoo2");
  }
}
