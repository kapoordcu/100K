package gk.practic.cint;

public class PawnResponse {

    private final String code;
    private final Integer value;

    private PawnResponse(String code, Integer value) {
        this.code = code;
        this.value = value;
    }

    public static PawnResponse accept(int value) {
        return new PawnResponse("ACCEPT", value);
    }

    public static PawnResponse reject() {
        return new PawnResponse("REJECT", null);
    }

    public String getCode() {
        return code;
    }

    public Integer getValue() {
        return value;
    }
}