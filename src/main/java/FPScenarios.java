package main.java;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FPScenarios {

    public List<String> startsWithFilter(List<String> names, String sequence) {
        return names.stream()
                .distinct()
                .sorted()
//                .map(String::toLowerCase)
                .filter(s -> s.startsWith(sequence.toLowerCase()) || s.startsWith(sequence.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .filter(n -> n % 2 == 1)
                .collect(Collectors.toList());
    }

    public int sumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public int sumOfOdds(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .distinct()
                .filter(n -> n % 2 == 1)
                .reduce(0, Integer::sum);
    }

    public List<Integer> primeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .filter(n -> {
                    boolean isPrime = true;
                    if (n <= 1)
                        return false;
                    for (int i = n - 1; i > 1; i--) {
                        if (n % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    return isPrime;
                })
                .collect(Collectors.toList());
    }

    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .distinct()
                .reduce(0, Integer::sum);
    }

    public List<Integer> squared(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public List<Integer> firstTenSquared() {
        return IntStream.range(1, 11)        //  or IntStream.rangeClosed(1,10)    //  upperBound is exclusive in range()
                .map(n -> n * n)
                .peek(e -> System.out.print(e + " "))
                .boxed()
                .toList();
    }

    public List<Integer> rangeSquared(int lowerBound, int upperBound) {
        return IntStream.rangeClosed(lowerBound, upperBound)    //  both bounds are inclusive in rangeClosed()
                .map(n -> n * n)
                .peek(e -> System.out.print(e + " "))
                .boxed()
                .toList();
    }

    public Optional<Integer> optionalPractice(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted()
                .filter(e -> e % 2 == 0)
                .map(e -> e * e)
                .reduce(Integer::max);
//                .max((a,b) -> Integer.compare(a,b));
    }
}
