package ek.jspice;

public class GeometricState
{
    public double[] state;

    
    public GeometricState()
    {
        state = new double[6];
    }
    
    
    @Override
    public String toString()
    {
        return String.format("Position: (%e, %e, %e), Velocity: (%e, %e, %e)", 
                state[0], state[1], state[2], state[3], state[4], state[5]);
    }
}
