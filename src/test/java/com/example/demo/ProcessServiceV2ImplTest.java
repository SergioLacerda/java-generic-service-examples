package com.example.demo;

import com.example.demo.solutionV2.domain.ManualItemV2;
import com.example.demo.solutionV2.domain.VendorItemV2;
import com.example.demo.solutionV2.service.impl.ProcessServiceV2Impl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProcessServiceV2ImplTest {

    @Autowired
    private ProcessServiceV2Impl processServiceV2Impl;

    @Test
    public void teste(){

        processServiceV2Impl.processList(List.of(
                new VendorItemV2("Printer"),
                new ManualItemV2("Wood Carving")
        ));
    }
}
