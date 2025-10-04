package com.example.demo.solution.service;

import com.example.demo.solution.domain.VendorItem;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    public void link(VendorItem item){
        System.out.println("Processing vendor item: " + item.getName());
    }

}
