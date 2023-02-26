
import java.math.BigInteger;
public class ElGamalKey implements java.security.Key 
{
	protected ElGamalKey()
	{
	}
    /** Creates new ElGamalKey */
    protected ElGamalKey(BigInteger p, BigInteger g) 
    {
        this.p = p;
        this.g = g;
        
    } // end ElGamalKey (constructor)

    public String getFormat()
    {
        return null;
        
    } // end getFormat
    
    public byte[] getEncoded()
    {
        return null;
        
    } // end getEncoded
    
    public java.lang.String getAlgorithm()
    {
        return "ElGamal";
        
    } // end getAlgorithm
    
    protected BigInteger getP()
    {
 
        return p;
        
    } // end getP
    
    protected BigInteger getG()
    {
        return g;
        
    } // end getG
    
    protected void setP(BigInteger p){
    	this.p = p;
    }
    
    protected void setG(BigInteger g){
    	this.g = g;
    }
    
    private static BigInteger p;
    private static BigInteger g;
    
} // end class ElGamalKey

