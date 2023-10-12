package com.pada.learnproject.graphqlexample.infracstructure;

import static org.springframework.graphql.execution.ErrorType.INTERNAL_ERROR;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

//Implementation without using Kickstarter which makes error handling much simpler
@Component
public class ExceptionHandler extends DataFetcherExceptionResolverAdapter {


    @Override protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        Throwable t = NestedExceptionUtils.getMostSpecificCause(ex);
        if (t instanceof RuntimeException) {
            return GraphqlErrorBuilder.newError(env)
                .errorType(INTERNAL_ERROR)
                .message("Invalid call")
                .build();
        }
        return null;
    }
}
