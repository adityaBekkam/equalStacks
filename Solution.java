import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int getMinHeight( int h1 , int h2 , int h3 ){
        if( Math.min(h1,h2)<Math.min(h2,h3) ){
            return Math.min( h1,h2 );
        }
        return Math.min( h2,h3 );
    }
    
    public static boolean areEqual( int h1 , int h2 , int h3 ){
        if( h1==h2 && h1==h3 ){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner( System.in );
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        int h1=0,h2=0,h3=0,i;
        int stack1[] = new int[n1];
        int stack2[] = new int[n2];
        int stack3[] = new int[n3];
        for( i=0 ; i<n1 ; i++ ){
            stack1[i] = scan.nextInt();
            h1 = h1 + stack1[i] ;
        }
        for( i=0 ; i<n2 ; i++ ){
            stack2[i] = scan.nextInt();
            h2 = h2 + stack2[i] ;
        }
        for( i=0 ; i<n3 ; i++ ){
            stack3[i] = scan.nextInt();
            h3 = h3 + stack3[i] ;
        }
        int index1=0 , index2=0 , index3=0 ,min;
        while( !Solution.areEqual(h1,h2,h3) ){    
            min = Solution.getMinHeight( h1,h2,h3 );
            while( h1>min && index1<n1 ){
                h1 = h1 - stack1[index1] ;
                index1++ ;
            }
            while( h2>min && index2<n2 ){
                h2 = h2 - stack2[index2] ;
                index2++ ;
            }
            while( h3>min && index3<n3 ){
                h3 = h3 - stack3[index3] ;
                index3++ ;
            }
            if( index1==n1 || index2==n2 || index3==n3 ){
                h1 = 0 ;
                break ;
            }
        }
        min = h1 ;
        System.out.println( min );
    }
}
