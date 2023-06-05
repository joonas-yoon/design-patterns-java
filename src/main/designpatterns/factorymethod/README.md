# Factory Method Pattern

```mermaid
classDiagram
    class Pizza
    class PizzaStore
    class NewYorkStylePizza
    class ChicagoStylePizza
    class NewYorkPizzaStore
    class ChicagoPizzaStore
    Pizza <|-- NewYorkStylePizza
    Pizza <|-- ChicagoStylePizza
    NewYorkPizzaStore --|> PizzaStore
    ChicagoPizzaStore --|> PizzaStore
    NewYorkStylePizza <-- NewYorkPizzaStore  
    ChicagoStylePizza <-- ChicagoPizzaStore
```
