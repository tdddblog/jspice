package ek.jspice;

public class OrbitalElements
{
    double[] data;
    
    
    public OrbitalElements()
    {
        // See SPICE_OSCLTX_NELTS in SpiceOsc.h
        data = new double[20];
    }
    
    
    public double getEccentricity()
    {
        return data[1];
    }

    
    public double getInclinationRad()
    {
        return data[2];
    }
    
    
    public double getSemiMajorAxisKm()
    {
        return data[9];
    }

    
    public double getOrbitalPeriodSec()
    {
        return data[10];
    }

}
