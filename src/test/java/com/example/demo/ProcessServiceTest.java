package com.example.demo;

import com.example.demo.solution.domain.Item;
import com.example.demo.solution.domain.ManualItem;
import com.example.demo.solution.domain.VendorItem;
import com.example.demo.solution.service.ProcessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessServiceTest {

    @Autowired
    private ProcessService processService;

    @Test
    public void teste(){

        List<Item> items = List.of(
            new VendorItem("Laptop"),
            new ManualItem("Wood sculpture"),
            new VendorItem("Monitor")
        );

        processService.processItems(items);
    }
}
