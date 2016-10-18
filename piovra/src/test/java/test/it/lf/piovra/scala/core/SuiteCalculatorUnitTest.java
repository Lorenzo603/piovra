package test.it.lf.piovra.scala.core;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import it.lf.piovra.scala.core.SuiteCalculator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Ignore
public class SuiteCalculatorUnitTest {

    private SuiteCalculator suiteCalculator = new SuiteCalculator();

    private class ContainsCombinationPredicate implements Predicate<List<String>> {

        private List<String> combinationValues;

        public ContainsCombinationPredicate(List<String> combinationValues) {
            this.combinationValues = combinationValues;
        }

        @Override
        public boolean apply(List<String> input) {
            if (input.size() != combinationValues.size()) {
                return false;
            }
            for (String expectedValue : combinationValues) {
                if (!Iterables.contains(input, expectedValue)) {
                    return false;
                }
            }
            return  true;
        }
    }

    @Test
    public void shouldCalculateCombinationsCorrectly() {

        HashMap<String, List<String>> inputMap = new HashMap<String, List<String>>() {{
            put("AAA", Arrays.asList("A00", "A01"));
            put("BBB", Arrays.asList("B10", "B11", "B12"));
            put("CCC", Arrays.asList("C20", "C21"));
        }};


        List<List<String>> result = suiteCalculator.calculate(inputMap);
        Assert.assertEquals(12, result.size());

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B10", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B10", "C21"))));

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B11", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B11", "C21"))));

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B12", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A00", "B11", "C21"))));

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B10", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B10", "C21"))));

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B11", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B11", "C21"))));

        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B12", "C20"))));
        Assert.assertTrue(Iterables.any(result, new ContainsCombinationPredicate(Arrays.asList("A01", "B12", "C21"))));

    }

}
