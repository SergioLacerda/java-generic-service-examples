# Item Processing System – V1 & V2

Este projeto demonstra duas abordagens para processar diferentes tipos de itens (`Item`) em uma aplicação Spring Boot, usando **injeção de dependência** e **dispatch automático para o processador correto**.

---

## Estrutura Comum

- **Item** — classe base para todos os itens.
- **ItemType (enum)** — identifica o tipo do item (usado na V1).  
- **ItemProcessor<T extends Item> / ProcessInterface<T>** — interface genérica para processar itens.  
- **ProcessService / ProcessServiceV2** — serviço principal que recebe uma lista de itens e delega para o processador correto.

---

## Visualização do Fluxo de Processamento

### V1 (ItemType Lookup)

```
ProcessService
   │
   ├─ item.getType() ──► ItemProcessorRegistry
   │                        │
   │                        └─ ManualProcessor ──► ManualService (lógica final)
   │                        └─ VendorProcessor ──► VendorService (lógica final)
```

- **Processor layer** existe: cada processor **generaliza a chamada ao serviço correspondente**, mas não contém lógica final.  
- Lookup baseado em **ItemType**.

---

### V2 (Class Lookup)

```
ProcessServiceV2
   │
   ├─ item.getClass() ──► ProcessorRegistry
                            │
                            └─ ManualServiceV2 implements ProcessInterface<ManualItemV2>
                            └─ VendorServiceV2 implements ProcessInterface<VendorItemV2>
```

- **Sem camada de processor**: os serviços implementam diretamente `ProcessInterface<T>`.  
- Lookup baseado na **classe real do item** (`item.getClass()`).  
- Suporta subclasses automaticamente.

---

## Versão 1 — V1

### Descrição

- Lookup por `ItemType`.  
- Cada `ItemProcessor` injeta o **serviço correspondente**, que contém a lógica final.  
- `ItemProcessorRegistry` registra **automaticamente** todos os processors via Spring.  
- `ProcessService` delega itens para o processor correto sem `if/else`.

### Benefícios

- Lookup simples via enum.  
- Registro automático pelo Spring.  
- ProcessService limpo e desacoplado.  
- Processors servem apenas como **dispatcher para os serviços finais**.

---

## Versão 2 — V2

### Descrição

- Lookup por **classe real do item (`item.getClass()`)**.  
- Cada serviço implementa `ProcessInterface<T>` diretamente, **sem processors intermediários**.  
- `ProcessorRegistry` registra todos os processadores automaticamente via Spring.  
- Suporta subclasses automaticamente.

### Benefícios

- Lookup totalmente type-safe.  
- Nenhum cast necessário no service.  
- Arquitetura modular e extensível.  
- Sem camada intermediária de processors.

---

## Comparação V1 x V2

| Característica                   | V1 (ItemType Lookup)                              | V2 (Class Lookup)                          |
|----------------------------------|--------------------------------------------------|-------------------------------------------|
| Lookup                           | Enum `ItemType`                                  | Classe real do item (`item.getClass()`)   |
| Tipo seguro (`type-safe`)         | Parcial, cast centralizado no registry           | Total, sem cast no service                 |
| Suporte a subclasses             | Não automático                                   | Sim, via `isAssignableFrom`                |
| Registro automático pelo Spring  | Sim                                              | Sim                                       |
| Camada intermediária (processor) | Sim, dispatch para serviços finais               | Não, serviços implementam ProcessInterface |
| Complexidade                      | Simples                                          | Um pouco mais avançada                     |
| Uso típico                        | Tipos fixos e conhecidos, lógica final nos serviços | Tipos variáveis/extensíveis, serviços diretos |

---

## Exemplo de Uso

### V1

```java
processService.processItems(List.of(
    new VendorItem("Printer"),
    new ManualItem("Wood Carving")
));
```

**Saída:**

```
VendorService linking: Printer
ManualService linking: Wood Carving
```

### V2

```java
processServiceV2.processList(List.of(
    new VendorItemV2("Printer"),
    new ManualItemV2("Wood Carving")
));
```

**Saída:**

```
VendorServiceV2 executing: Printer
ManualServiceV2 executing: Wood Carving
```

---

## Conclusão

- **V1**: bom para cenários com tipos conhecidos e fixos, processadores generalizam chamadas para os serviços.  
- **V2**: mais flexível e extensível, dispatch baseado em classe, sem processors intermediários.  
- Ambas usam **injeção de dependência Spring** para registro automático dos processadores.  

