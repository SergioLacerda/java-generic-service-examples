package com.example.demo.solution.domain;

import com.example.demo.enums.ItemType;

public class VendorItem implements Item {
    private final String name;
    public VendorItem(String name) { this.name = name; }

    @Override
    public ItemType getType() { return ItemType.VENDOR; }
    public String getName() { return name; }
}