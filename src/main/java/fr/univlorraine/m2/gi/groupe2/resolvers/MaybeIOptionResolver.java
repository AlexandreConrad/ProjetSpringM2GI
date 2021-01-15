package fr.univlorraine.m2.gi.groupe2.resolvers;

import fr.univlorraine.m2.gi.groupe2.model.Option;

public class MaybeIOptionResolver implements IOptionResolver {
    @Override
    public boolean shouldMatch(Option option) {
        return option.getName().equals("Disponible") || option.getName().equals("Peut-être");
    }
}
