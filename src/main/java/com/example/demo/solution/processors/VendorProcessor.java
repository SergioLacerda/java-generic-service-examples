package com.example.demo.solution.processors;

import com.example.demo.enums.ItemType;
import com.example.demo.solution.domain.VendorItem;
import com.example.demo.solution.ports.ItemProcessor;
import com.example.demo.solution.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class VendorProcessor implements ItemProcessor<VendorItem> {

    @Autowired
    private VendorService vendorService;

    @Override
    public ItemType getSupportedType() {
        return ItemType.VENDOR;
    }

    @Override
    public void process(VendorItem item) {
        vendorService.link(item);
    }
}
