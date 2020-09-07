package com.techie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the seed value for a:");
	    Long a = input.nextLong();

        System.out.println("Please enter the seed value for b:");
	    Long b = input.nextLong();

        System.out.println("Please enter the number of iterations:");
	    int numIteration = input.nextInt();

	    Long[][] mem = new Long[numIteration][numIteration];

	    for (int i = 0; i < numIteration; i++){
            Long[] temp = generate(a, b);
	        for (int j = 0; j < 2; j++){
	            mem[i][j] = temp[j];
            }

	        //update generators for the next iteration
            a = mem[i][0];
	        b = mem[i][1];
        }

	    //finally, comapre values
        checker(mem);
    }

    public static Long[] generate(Long num1, Long num2){
        Long genA = num1;
        Long genB = num2;

        int genAFactor = 16807;
        int genBFactor = 48271;
        int divisor = 2147483647;

        //multiply generators with factors
        genA = genA * genAFactor;
        genB = genB * genBFactor;

        //divide by the divisor

        Long resultA = genA % divisor;
        Long resultB = genB % divisor;

        return new Long[] {resultA, resultB};
    }

    public static String binarizer(Long num){
        return  Long.toBinaryString(num);
    }

    public static void checker(Long[][] mem){
        for (int i = 0; i < mem.length; i++){
            String a = binarizer(mem[i][0]);
            String b = binarizer(mem[i][1]);

            //compare last 8 bits
            String aBit = a.substring(a.length() - 8);
            String bBit = b.substring(b.length() - 8);
            if (aBit.equals(bBit))
                System.out.println(aBit.concat(" -> ").concat(bBit));
        }
    }
}
