package util;

public class Contract
{
    public static void require (boolean b, String desc)
    {
        if (!b)
            throw new PreconditionViolation (desc);
    }
    
    public static void assume (boolean b, String message)
    {
        assert b : message;
    }
    
    public static void ensure (boolean b, String message)
    {
        assert b : message;
    }
}
