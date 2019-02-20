package kata.stringcalc;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author jacob.briscoe
 */
public class Calculator {

    public static int add(final String input) {
        if ("".equals(input)) {
            return 0;
        }
        
        final List<Integer> numbers = Pattern.compile("[,|\n]").splitAsStream(input)
                .map(Integer::valueOf).collect(Collectors.toList());

        final Optional<Integer> maybeNegativeNumber = numbers.stream().filter(x -> x < 0).findAny();

        maybeNegativeNumber.ifPresent(value -> {
            throw new IllegalArgumentException(String.format("negative value %s not allowed", value));
        });

        return numbers.stream().filter(x -> x <= 1000).reduce(0, Integer::sum);
    }

}
