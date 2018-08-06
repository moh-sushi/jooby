package io.jooby.internal;

import io.jooby.Handler;
import io.jooby.Route;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RouteImpl implements Route {

  private final String method;
  private final String pattern;
  private final Handler handler;
  private final Map<String, String> params;
  List<String> paramKeys;

  public RouteImpl(String method, String pattern, Handler handler) {
    this.method = method.toUpperCase();
    this.pattern = pattern;
    this.params = Collections.EMPTY_MAP;
    this.handler = handler;
  }

  private RouteImpl(String method, String pattern, Map<String, String> params, Handler handler) {
    this.method = method;
    this.pattern = pattern;
    this.params = params;
    this.handler = handler;
  }

  @Override public Map<String, String> params() {
    return params;
  }

  @Override public String pattern() {
    return pattern;
  }

  @Override public String method() {
    return method;
  }

  @Override public Handler handler() {
    return handler;
  }

  Route newRuntimeRoute(String method, Map<String, String> params) {
    return new RouteImpl(method, pattern, params, handler);
  }

  @Override public String toString() {
    return method + " " + pattern;
  }
}