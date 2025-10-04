package com.example.demo.solutionV2.service.impl;

import com.example.demo.solutionV2.domain.VendorItemV2;
import com.example.demo.solutionV2.service.ProcessInterface;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceV2Impl implements ProcessInterface<VendorItemV2> {
    @Override
    public void execute(VendorItemV2 item) {
        System.out.println("VendorServiceV2 executing: " + item.getName());
    }
}