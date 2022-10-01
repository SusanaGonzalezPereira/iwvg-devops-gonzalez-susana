package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

public class Searches {

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Objects::nonNull)
                )
                .reduce(Fraction::add)
                .orElse(new Fraction(0, 1));
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(Fraction::isProper)
                )
                .findFirst()
                .orElse(new Fraction(0, 1));
    }

}