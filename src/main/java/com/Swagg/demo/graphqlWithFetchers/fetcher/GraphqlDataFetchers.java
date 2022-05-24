package com.Swagg.demo.graphqlWithFetchers.fetcher;

import com.Swagg.demo.exception.PizzaNotExistsException;
import com.Swagg.demo.module.pizza.dto.PizzaDto;
import com.Swagg.demo.module.pizza.service.GenericService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GraphqlDataFetchers implements DataFetcher<List<PizzaDto>> {

    private final GenericService<PizzaDto> pizzaService;

    public GraphqlDataFetchers(GenericService<PizzaDto> pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    public List<PizzaDto> get(DataFetchingEnvironment environment) {
        return pizzaService.getAll();
    }

    public DataFetcher<PizzaDto> getPizzaBySlugDataFetcher() {
        return dataFetchingEnvironment -> {
            String pizzaSlug = dataFetchingEnvironment.getArgument("slug");
            try {
                return pizzaService.get(pizzaSlug);
            } catch (Exception e) {
                throw new PizzaNotExistsException();
            }
        };
    }

    public DataFetcher<List<PizzaDto>> getPizzasDataFetcher() {
        return dataFetchingEnvironment -> {
            try {
                return pizzaService.getAll();
            } catch (Exception e) {
                throw new PizzaNotExistsException();
            }
        };
    }

}
