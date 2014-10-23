package cz.muni.fi.pv243.seminar.cdi.factorial.view;

import java.math.BigInteger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.muni.fi.pv243.seminar.cdi.factorial.Factorial;
import cz.muni.fi.pv243.seminar.cdi.factorial.Parallel;

/**
 * Backing bean for the factorial form (factorial.xhtml)
 */
@Named("factorial")
@RequestScoped
public class FactorialForm {

    private Long input;
    private BigInteger result;

    @Inject
    @Parallel
    private Factorial factorial;

    public void compute() {
        result = factorial.compute(input);
    }

    public void reset() {
        this.input = null;
        this.result = null;
    }

    public Long getInput() {
        return input;
    }

    public void setInput(Long input) {
        this.input = input;
    }

    public BigInteger getResult() {
        return result;
    }
}
