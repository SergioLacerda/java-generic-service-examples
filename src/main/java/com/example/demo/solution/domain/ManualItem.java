package com.example.demo.solution.domain;

import com.example.demo.enums.ItemType;

public class ManualItem implements Item {
    private final String description;
    public ManualItem(String description) { this.description = description; }

    @Override
    public ItemType getType() { return ItemType.MANUAL; }

    public String getDescription() { return description; }
}
