package pl.lotafak.compute;

import java.io.Serializable;

public class Factorial implements Task<Integer>, Serializable {
    private static final long serialVersionUID = 227L;

    int factorialN;

    public Factorial(int i) {
        factorialN = i;
    }

    @Override
    public Integer execute() {
        int result = 1;
        for (int i = 1; i <= factorialN; i++) {
            result = result * i;
        }
        return result;
    }
}
