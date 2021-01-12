package io.swagger.resolvers;

import io.swagger.model.Option;

public class AvailableIOptionResolver implements IOptionResolver {
    @Override
    public boolean shouldMatch(Option option) {
        return option.getName().equals("Disponible");
    }
}
