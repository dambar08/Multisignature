
import java.security.SecureRandom;
import java.security.SignatureException;
import java.math.*;
import java.io.ByteArrayOutputStream;

public class SignatureGeneration {

	private int strength;
	private SecureRandom secureRandom;

	private static final int DEFAULT_STRENGTH = 3;
	private static final int DEFAULT_CERTAINTY = 5;
	protected ElGamalKey key;

	private ByteArrayOutputStream byteOut;
	protected static final BigInteger BIG_ONE = BigInteger.valueOf(1);
	
	public SignatureGeneration()throws Exception
	{
	}
	public SignatureGeneration(byte[] msg) throws Exception
	{
    	strength = 0;
    	secureRandom = null;
    	byteOut = new ByteArrayOutputStream();
		byte[] b = msg;
		byteOut.write(b);
	} 

	public void initialize(int strength, SecureRandom secureRandom)
	{
    	this.strength = strength;
    	this.secureRandom = secureRandom;
    
	}

	public void generateKeyPair()throws Exception
	{
    	if (secureRandom == null)
    	{
        		initialize(DEFAULT_STRENGTH, new SecureRandom());
    	}
    
    	BigInteger p = new BigInteger(strength, DEFAULT_CERTAINTY, secureRandom);		
    	BigInteger g = new BigInteger(strength - 1, secureRandom);

    	BigInteger x = new BigInteger(strength - 1, secureRandom);
    	BigInteger y = g.modPow(x, p);   
    	
    	new ElGamalPublicKey(p, g, y);
    	new ElGamalPrivateKey(p, g, x);

	}


	public byte[] signatureGeneration()throws Exception
	{
		ElGamalKey key = new ElGamalKey(); 
		
        BigInteger p = key.getP();
        BigInteger g = key.getG();
        BigInteger x = ElGamalPrivateKey.getX();
        BigInteger y = ElGamalPublicKey.getY();
        
		if (secureRandom == null)
    	{
        		initialize(DEFAULT_STRENGTH, new SecureRandom());
    	}
    	BigInteger m = new BigInteger(1, byteOut.toByteArray());
    	BigInteger k;
    	BigInteger a;
    	BigInteger b;
    
    	do
    	{
        	k = new BigInteger(p.bitLength() - 1, secureRandom);
        
    	} while (!(k.gcd(p.subtract(BIG_ONE))).equals(BIG_ONE));

    	

    	a = g.modPow(k, p);
    	

    	BigInteger numerator = m.subtract(x.multiply(a));

    	b = (numerator.divide(k)).mod(p.subtract(BIG_ONE));
    	

    	int modulusLength = (p.bitLength() + 7) / 8;
    	byte[] signature = new byte[modulusLength * 2];
    	String s = new String(a+","+b+","+p+","+g+","+y);
    	signature = s.getBytes();
    	
    	return signature;
	}

	protected boolean engineVerify(byte[] signature) throws SignatureException
	{   
		ElGamalKey key = new ElGamalKey(); 
		
		BigInteger y = ElGamalPublicKey.getY();
	    BigInteger p = key.getP();
	    BigInteger g = key.getG();
    	
    	String s = new String(signature);
    	
    	String ss[] = s.split(",");    	
    	BigInteger a = new BigInteger(ss[0]);
    	BigInteger b = new BigInteger(ss[1]);
    	
    	BigInteger recieved = y.modPow(a, p).multiply(a.modPow(b, p)).mod(p);
    	
    	BigInteger m = new BigInteger(1, byteOut.toByteArray());
    	System.out.println("Receiver verifcation Signature:"+recieved);
    	BigInteger sent = g.modPow(m, p);
    	System.out.println("Sender signature:"+sent);
    	return recieved.equals(sent);
    
	} 

	protected byte[] getBytes(BigInteger bigInt)throws Exception
	{
    	byte[] bigBytes = bigInt.toByteArray();
        if ((bigInt.bitLength() % 8) != 0)
    	{
            	return bigBytes;
    	}
        else
    	{
            	byte[] smallBytes = new byte[bigInt.bitLength() / 8];
    	    	System.arraycopy(bigBytes, 1, smallBytes, 0, smallBytes.length);        
        		return smallBytes;
        }
    
	}

	public static void main(String[] args) throws Exception
	{
		
	}

}
