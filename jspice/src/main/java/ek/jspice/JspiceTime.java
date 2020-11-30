package ek.jspice;

import com.sun.jna.ptr.DoubleByReference;


public class JspiceTime
{
    public static double utcToEphemerisTime(String utc)
    {
        DoubleByReference et = new DoubleByReference();
        JNAcspice.INSTANCE.utc2et_c(utc, et);
        return et.getValue();
    }

    
    public static double stringToEphemerisTime(String utc)
    {
        DoubleByReference et = new DoubleByReference();
        JNAcspice.INSTANCE.str2et_c(utc, et);
        return et.getValue();
    }

}
