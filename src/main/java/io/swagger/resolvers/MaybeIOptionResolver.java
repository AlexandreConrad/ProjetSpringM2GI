package io.swagger.resolvers;

import io.swagger.model.Option;

public class MaybeIOptionResolver implements IOptionResolver {
    @Override
    public boolean shouldMatch(Option option) {
        return option.getName().equals("Disponible") || option.getName().equals("Peut-être");
    }
}
