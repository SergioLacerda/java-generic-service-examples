package com.example.demo.solution.service;

import com.example.demo.solution.domain.ManualItem;
import org.springframework.stereotype.Service;

@Service
public class ManualService {
    public void link(ManualItem item){
        System.out.println("Processing vendor item: " + item.getDescription());

    }
}
