import java.util.function.Supplier;
class DelayedEvaluation {
    private Supplier<Integer> delayedEvaluation;
    public DelayedEvaluation(Supplier<Integer> supplier) {
        this.delayedEvaluation = supplier;
    }
    private int sum;
    public int eval() {
        synchronized (DelayedEvaluation.class){
            sum = delayedEvaluation.get();
            delayedEvaluation = null;
            return sum;
        }
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
