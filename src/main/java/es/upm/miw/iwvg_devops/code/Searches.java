package es.upm.miw.iwvg_devops.code;


import org.apache.logging.log4j.LogManager;

import java.util.Objects;
import java.util.stream.Stream;

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


}