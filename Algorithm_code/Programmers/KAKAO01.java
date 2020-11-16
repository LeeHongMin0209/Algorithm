package Programmers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'diverseDeputation' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER w
     */

    public static int diverseDeputation(int m, int w) {
    	if(m != 0 && w != 0) {
    		int temp1 = 1;
    		for(int i = 1; i <= w; i++) {
    			temp1 *= i;
    		}
    		for(int i = 1; i <= w-2; i++) {
    			temp1 /= i;
    		}
    		temp1 /= 2;
    		int com1 = m * temp1;
    		
    		int temp2 = 1;
    		for(int i = 1; i <= m; i++) {
    			temp2 *= i;
    		}
    		temp2 /= 2;
    		int com2 = w * temp2;
    		return com1 + com2;
    	} 
    	else return 0;
    }
    
}
public class KAKAO01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int w = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.diverseDeputation(m, w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

