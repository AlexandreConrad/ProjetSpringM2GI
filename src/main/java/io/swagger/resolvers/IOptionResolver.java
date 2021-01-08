package io.swagger.resolvers;

import io.swagger.model.Option;

public interface IOptionResolver {

    boolean shouldMatch(Option option);
}
