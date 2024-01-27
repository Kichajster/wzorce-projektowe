import java.util.function.Supplier;
class DelayedEvaluation {
    private final Supplier<Integer> delayedEvaluation;

    public DelayedEvaluation(Supplier<Integer> supplier) {
        this.delayedEvaluation = supplier;
    }

    public int eval() {
        return delayedEvaluation.get();
    }
}

public class Main {
    public static void main(String[] args) {
        int a = 3 + 4;
        // natychmiastowa ewaluacja
        System.out.println("Eagerly Evaluated Result: " + a);

        // opóźniona ewaluacja
        DelayedEvaluation delayedEvaluation = new DelayedEvaluation(() -> 3 + 4);
        System.out.println("Lazily Evaluated Result: " + delayedEvaluation.eval());
    }
}
