package com.example.demo.solutionV2.config;

import com.example.demo.solutionV2.domain.ItemV2;
import com.example.demo.solutionV2.service.ProcessInterface;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProcessorRegistry {

    private final Map<Class<?>, ProcessInterface<?>> processorMap = new HashMap<>();

    public ProcessorRegistry(List<ProcessInterface<?>> processors) {
        for (ProcessInterface<?> processor : processors) {
            Class<?> userClass = ClassUtils.getUserClass(processor);
            Class<?> genericType = ResolvableType.forClass(userClass)
                .as(ProcessInterface.class)
                .getGeneric(0)
                .resolve();
            if (genericType != null) {
                processorMap.put(genericType, processor);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ItemV2> ProcessInterface<T> getProcessor(T item) {
        return (ProcessInterface<T>) processorMap.entrySet().stream()
                .filter(e -> e.getKey().isAssignableFrom(item.getClass()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "No processor found for " + item.getClass()
                ));
    }
}
