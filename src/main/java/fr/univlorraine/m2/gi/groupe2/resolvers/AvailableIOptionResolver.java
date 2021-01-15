package fr.univlorraine.m2.gi.groupe2.resolvers;

import fr.univlorraine.m2.gi.groupe2.model.Option;

public class AvailableIOptionResolver implements IOptionResolver {
    @Override
    public boolean shouldMatch(Option option) {
        return option.getName().equals("Disponible");
    }
}
