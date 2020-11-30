package ek.jspice;

import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;


public class Jspice
{
    public static void loadKernel(String file)
    {
        JNAcspice.INSTANCE.furnsh_c(file);
    }
    
    /**
     * Get body values (double)
     * @param bodyId
     * @param item
     * @param retValues Output parameter. Should be initialized.
     * @return number of values
     */
    public static int getBodyValues(int bodyId, String item, double[] retValues)
    {
        IntByReference retNum = new IntByReference();
        JNAcspice.INSTANCE.bodvcd_c(bodyId, item, retValues.length, retNum, retValues);
        return retNum.getValue();
    }
    
    
    public static double getGeometricState(int targetBodyId, double epoch, String refFrame, 
            int observingBodyId, GeometricState state)
    {
        DoubleByReference lt = new DoubleByReference();
        JNAcspice.INSTANCE.spkgeo_c(targetBodyId, epoch, refFrame, observingBodyId, state.state, lt);
        return lt.getValue();
    }

    
    public static void getOrbitalElements(GeometricState state, double et, double mu, OrbitalElements elements)
    {
        JNAcspice.INSTANCE.oscltx_c(state.state, et, mu, elements.data);
    }
    
    
    public static double convert(double fromValue, String fromUnit, String toUnit)
    {
        DoubleByReference retValue = new DoubleByReference();
        JNAcspice.INSTANCE.convrt_c(fromValue, fromUnit, toUnit, retValue);
        return retValue.getValue();
    }
}
