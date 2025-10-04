package com.example.demo.solutionV2.domain;

public class ManualItemV2 implements ItemV2 {
    private final String name;
    public ManualItemV2(String name) { this.name = name; }
    public String getName() { return name; }
}