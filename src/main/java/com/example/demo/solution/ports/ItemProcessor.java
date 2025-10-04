package com.example.demo.solution.ports;

import com.example.demo.enums.ItemType;
import com.example.demo.solution.domain.Item;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface ItemProcessor<T extends Item> {
    ItemType getSupportedType();
    void process(T item);

    static Map<ItemType, ItemProcessor<? extends Item>> mapByType(List<ItemProcessor<? extends Item>> processors) {
        return processors.stream()
            .collect(Collectors.toMap(ItemProcessor::getSupportedType, Function.identity()));
    }
}
