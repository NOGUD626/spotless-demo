package com.example;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, Spotless!");
    List<String> names = new ArrayList<>();
    names.add("world");
    names.add("spotless");
    for (String n : names) {
      System.out.println("Hi, " + n);
    }
  }
}
