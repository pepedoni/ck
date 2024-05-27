package com.github.mauricioaniche.ck.exceptions;


public class InvalidUserMetricsException extends RuntimeException {
  public InvalidUserMetricsException(String error) {
    super("Invalid add to user metrics: " + error);
  }
}