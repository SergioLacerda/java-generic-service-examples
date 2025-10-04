package com.example.demo.solution.processors.config;

import com.example.demo.enums.ItemType;
import com.example.demo.solution.domain.Item;
import com.example.demo.solution.ports.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ItemProcessorRegistry {

    private final Map<ItemType, ItemProcessor<? extends Item>> registry = new HashMap<>();

    public ItemProcessorRegistry(List<ItemProcessor<? extends Item>> processors) {
        for (ItemProcessor<? extends Item> processor : processors) {
            registry.put(processor.getSupportedType(), processor);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Item> ItemProcessor<T> getProcessor(ItemType type) {
        return (ItemProcessor<T>) registry.get(type);
    }
}