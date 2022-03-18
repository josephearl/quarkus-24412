package com.example.foo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class FoosResponse {
  @Schema(example = "foo1, foo2, foo3")
  private final String foos;

  public FoosResponse(String foos) {
    this.foos = foos;
  }

  public String getFoos() {
    return foos;
  }
}
