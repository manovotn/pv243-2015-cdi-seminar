package cz.muni.fi.pv243.seminar.cdi.factorial;

import java.math.BigInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import cz.muni.fi.pv243.seminar.cdi.factorial.util.FactorialComputationFinished;

@ApplicationScoped
public class FactorialImpl implements Factorial {

    @Inject
    private MathOperations math;

    @Inject
    private Event<FactorialComputationFinished> event;

    @Override
    public BigInteger compute(long number) {
        BigInteger result = number == 0 ? BigInteger.ONE : math.multiplySequence(1, number);
        fireEvent(number, result);
        return result;
    }

    protected BigInteger fireEvent(long number, BigInteger result) {
        event.fire(new FactorialComputationFinished(number, result));
        return result;
    }
}
