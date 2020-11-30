package tt;


import ek.jspice.GeometricState;
import ek.jspice.Jspice;
import ek.jspice.JspiceTime;
import ek.jspice.OrbitalElements;


public class TestOrbitalElements
{
    private static String[] PLANETS =
    {
        "", "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Satrurn", "Uranus", "Neptune", "Pluto"
    };
    
    
    public static void main(String[] args)
    {
        System.setProperty("jna.library.path", "/ws2/SPICE");
        
        Jspice.loadKernel("/ws2/SPICE/gen/naif0012.tls");
        Jspice.loadKernel("/ws2/SPICE/gen/de432s.bsp");
        Jspice.loadKernel("/ws2/SPICE/gen/gm_de431.tpc");

        double et = JspiceTime.stringToEphemerisTime("10/10/2020");
        int SUN_ID = 10;
        double SUN_GM = getGM(SUN_ID);

        GeometricState state = new GeometricState();
        OrbitalElements el = new OrbitalElements();
        
        System.out.println("---------------------------------------------");
        System.out.format("%8s %8s %8s %8s %8s\n", "", "sma", "ecc", "period", "incl");
        System.out.println("---------------------------------------------");
        
        for(int targetId = 1; targetId < PLANETS.length; targetId++)
        {
            Jspice.getGeometricState(targetId, et, "ECLIPJ2000", SUN_ID, state);
            Jspice.getOrbitalElements(state, et, SUN_GM, el);
            double sma = Jspice.convert(el.getSemiMajorAxisKm(), "KM", "AU");            
            double period = Jspice.convert(el.getOrbitalPeriodSec(), "SECONDS", "YEARS");
            double incl = Math.toDegrees(el.getInclinationRad());
            
            System.out.format("%8s %8.2f %8.2f %8.2f %8.2f\n", PLANETS[targetId], sma, el.getEccentricity(), period, incl);
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("    sma - Semi-major axis, au");
        System.out.println("    ecc - Eccentricity");
        System.out.println(" period - Orbital period, years");
        System.out.println("   incl - Inclination, degrees");
    }

    
    private static double getGM(int bodyId)
    {
        double values[] = new double[1];
        Jspice.getBodyValues(10, "GM", values);
        return values[0];
    }
    
}
