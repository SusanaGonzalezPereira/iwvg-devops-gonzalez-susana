package es.upm.miw.iwvg_devops.code;


import org.apache.logging.log4j.LogManager;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream()
                        .filter(i -> null != i)
                )
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

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