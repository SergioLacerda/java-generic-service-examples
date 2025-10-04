package com.example.demo.solutionV2.config;

public class ProcessorConfig {

//    @Bean
//    public ProcessorRegistry processorRegistry(List<ProcessInterface<?>> processors) {
//        Map<Class<?>, ProcessInterface<?>> processorMap = new HashMap<>();
//        for (ProcessInterface<?> processor : processors) {
//            Class<?> userClass = ClassUtils.getUserClass(processor);
//            Class<?> genericType = ResolvableType.forClass(userClass)
//                    .as(ProcessInterface.class)
//                    .getGeneric(0)
//                    .resolve();
//            if (genericType != null) {
//                processorMap.put(genericType, processor);
//            }
//        }
//        return new ProcessorRegistry(processorMap);
//    }
}
