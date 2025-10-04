package com.example.demo.solution.processors.config;

import com.example.demo.enums.ItemType;
import com.example.demo.solution.domain.Item;

public interface ItemProcessor<T extends Item> {
    void process(T item);
    ItemType getSupportedType();
}