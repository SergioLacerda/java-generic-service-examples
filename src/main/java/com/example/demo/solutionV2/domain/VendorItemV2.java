package com.example.demo.solutionV2.domain;

public class VendorItemV2 implements ItemV2 {
    private final String name;
    public VendorItemV2(String name) { this.name = name; }
    public String getName() { return name; }
}