
import java.math.*;
public class ElGamalPrivateKey extends ElGamalKey implements java.security.PrivateKey 
{

	/** Creates new ElGamalPrivateKey */
	protected ElGamalPrivateKey() 
	{

	}
	protected ElGamalPrivateKey(BigInteger p, BigInteger g, BigInteger x) 
	{
		super(p, g);
		this.x = x;
		
	} // end ElGamalPrivateKey (constructor)

	protected static BigInteger getX()
	{
	return x;
	
	} // end getX

	protected void setX(BigInteger x){
    	this.x = x;
    }
	private static BigInteger x;

} // end class ElGamalPrivateKey
