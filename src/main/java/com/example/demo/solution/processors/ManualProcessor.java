package com.example.demo.solution.processors;

import com.example.demo.enums.ItemType;
import com.example.demo.solution.domain.ManualItem;
import com.example.demo.solution.ports.ItemProcessor;
import com.example.demo.solution.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManualProcessor implements ItemProcessor<ManualItem> {

    @Autowired
    private ManualService manualService;

    @Override
    public ItemType getSupportedType() {
        return ItemType.MANUAL;
    }

    @Override
    public void process(ManualItem item) {
        manualService.link(item);
    }
}