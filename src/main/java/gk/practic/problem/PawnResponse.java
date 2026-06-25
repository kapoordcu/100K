package gk.practic.problem;

public class PawnResponse {

    private final ResponseState state;
    private final Integer value;

    private PawnResponse(ResponseState state, Integer value) {
        this.state = state;
        this.value = value;
    }

    public static PawnResponse accept(int value) {
        return new PawnResponse(ResponseState.ACCEPT, value);
    }

    public static PawnResponse reject() {
        return new PawnResponse(ResponseState.REJECT, null);
    }

    public ResponseState getState() {
        return state;
    }

    public Integer getValue() {
        return value;
    }
}