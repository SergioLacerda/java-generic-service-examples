package com.example.demo.solutionV2.service.impl;

import com.example.demo.solutionV2.config.ProcessorRegistry;
import com.example.demo.solutionV2.domain.ItemV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceV2Impl {

    @Autowired
    private ProcessorRegistry registry;

    public <T extends ItemV2> void processItem(T item) {
        registry.getProcessor(item).execute(item);
    }

    public <T extends ItemV2> void processList(List<T> items) {
        items.forEach(this::processItem);
    }
}