
import java.math.*;
public class ElGamalPublicKey extends ElGamalKey 
implements java.security.PublicKey 
{

	/** Creates new ElGamalPublicKey */
	protected ElGamalPublicKey() 
	{
	}
	protected ElGamalPublicKey(BigInteger p, BigInteger g, BigInteger y) 
	{
		super(p, g);
		this.y = y;
		
	} // end ElGamalPublicKey

	protected static BigInteger getY()
	{
		return y;
	
	} // end getY
	
	protected void setY(BigInteger y){
    	this.y = y;
    }
	
	private static BigInteger y;

} // end class ElGamalPublicKey
