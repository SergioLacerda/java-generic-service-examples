package com.example.demo.solutionV2.service.impl;

import com.example.demo.solutionV2.domain.ManualItemV2;
import com.example.demo.solutionV2.service.ProcessInterface;
import org.springframework.stereotype.Service;

@Service
public class ManualServiceV2Impl implements ProcessInterface<ManualItemV2> {
    @Override
    public void execute(ManualItemV2 item) {
        System.out.println("ManualServiceV2 executing: " + item.getName());
    }
}