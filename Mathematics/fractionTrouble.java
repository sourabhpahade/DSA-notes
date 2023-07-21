package Mathematics;

public class fractionTrouble {


    // we neee to find greatest p/q <= n/d i.e p*d <= n*q

    public int[]  LargestFraction(int n, int d)
    {
        // code here
        int [] res = new int[2];

        // making req numerator and denominator
        int d1 = 1;
        int n1 = 0;
        
        for(int q=10000;q>=2;q--){
            
            // current numerator
            int p = (n*q-1)/d;
            
            // checking current p/q >= req n1/d1
            if(p*d1>=q*n1){
                n1=p;
                d1=q;
            }
        }
        
        // making n1,d1 gcd==1
        int gcd = gcd(n1,d1);
        res[0]=n1/gcd;
        res[1]=d1/gcd;
        
        return res;
        
    }
    
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}