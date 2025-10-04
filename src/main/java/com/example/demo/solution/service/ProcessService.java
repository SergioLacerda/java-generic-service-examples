package com.example.demo.solution.service;

import com.example.demo.solution.domain.Item;
import com.example.demo.solution.ports.ItemProcessor;
import com.example.demo.solution.processors.config.ItemProcessorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessService {

    @Autowired
    private ItemProcessorRegistry processorRegistry;

    public void processItems(List<Item> items) {
        for (Item item : items) {
            ItemProcessor<Item> processor = processorRegistry.getProcessor(item.getType());
            processor.process(item);
        }
    }
}