package util;

public class PreconditionViolation extends RuntimeException
{   
    private static final long serialVersionUID = 3013729236845397809L;

    public PreconditionViolation (String message) {
        super ("requires" + message);
    }
}
