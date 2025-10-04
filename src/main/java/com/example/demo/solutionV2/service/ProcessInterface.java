package com.example.demo.solutionV2.service;

import com.example.demo.solutionV2.domain.ItemV2;

public interface ProcessInterface<T extends ItemV2> {
    void execute(T item);
}
