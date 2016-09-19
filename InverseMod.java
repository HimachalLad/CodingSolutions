/*
 * CSE 2013, NIT SILCHAR
 */
package PowerGCD;

/**
 *
 * @author Nikhil Pathania
 */

/*

long modPow(long a,long b,long MOD)
{
long res=1;
 a%=MOD;
 for(;b;b>>=1)
    {
        if(b&1)res=res*a%MOD;
          a=a*a%MOD;
    }
 return res;
}

ll modInverse(long a){
    return modPow(a,mod-2,mod);
    }

*/


public class InverseMod {

    /**
     * @param args the command line arguments
     */
    static int mod = (int)1e9+7;
    public static void main(String[] args) {
        long a = 3, m = 1000000007;
        long ans=(modInverse(a, m));
        System.out.println((ans)%m);
    }
    public static long modInverse(long a, long m)
{
        // If a and m are relatively prime, then modulo inverse
        // is a^(m-2) mode m
       return power(a, m-2, m);
    
}
 
// To compute x^y under modulo m
     private static long power(long base, long exp, long mod) {

       
        base = base % mod;
        long result =1;
        while(exp > 0)
        {
            if(exp % 2== 1)
            {
                result = (result * base) % mod;
                exp --;
            }
            else
            {
                base = (base * base) % mod;
                exp = exp >> 1;
            }
            
        }
         return result;
     }



 // Function to return gcd of a and b
public static long gcd(long a, long b)
{
    if (a == 0)
        return b;
    return gcd(b%a, a);
}
 
public static long lcm(long a, long b){
    long x = (a%mod * b%mod)%mod;
    return x/gcd(a, b);
}
}
