package ek.jspice;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;


interface JNAcspice extends Library
{
    JNAcspice INSTANCE = (JNAcspice)Native.load("cspice", JNAcspice.class);

    void furnsh_c(String file);
    
    // Time
    void str2et_c(String utcstr, DoubleByReference et);
    void utc2et_c(String utcstr, DoubleByReference et);
    
    // Conversion
    void convrt_c(double fromValue, String fromUnit, String toUnit, DoubleByReference retValue);
    
    // Body properties
    void bodvcd_c(int bodyId, String item, int maxNumValues, IntByReference retNumValues, double[] retValues);

    // Geometric state
    void spkgeo_c(int targetId, double et, String frame, int observingId, double retState[], DoubleByReference retLightTime);
    
    // Orbital elements
    void oscltx_c(double[] state, double et, double mu, double[] retVals20); 
}
