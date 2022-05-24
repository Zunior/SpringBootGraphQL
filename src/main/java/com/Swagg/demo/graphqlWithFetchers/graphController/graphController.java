package com.Swagg.demo.graphqlWithFetchers.graphController;

import com.Swagg.demo.graphqlWithFetchers.provider.GraphQLProvider;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class graphController {

    GraphQLProvider provider;

    @Autowired
    public graphController(GraphQLProvider provider) {
        this.provider = provider;
    }

    @PostMapping("/graphql")
    public ExecutionResult graphQl(@RequestBody queryData query) {
        return provider.graphQL().execute(query.getQuery());
    }
}
