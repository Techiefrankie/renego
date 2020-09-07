package com.techie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the seed value for a:");
	    Long a = input.nextLong();

        System.out.println("Please enter the seed value for b:");
	    Long b = input.nextLong();

	    int genAFactor, genBFactor, divisor;
        System.out.println("Please enter the number of iterations:");
	    int numIteration = input.nextInt();

        System.out.println("Do you want to set a factor for generator A? y/n:");
        String response = input.next();
        if (response.equalsIgnoreCase("y")) {
            genAFactor = input.nextInt();
        }
        else {
            genAFactor = 16807;
        }

        System.out.println("Do you want to set a factor for generator B? y/n:");
        response = input.next();
        if (response.equalsIgnoreCase("y")) {
            genBFactor = input.nextInt();
        }
        else {
            genBFactor = 48271;
        }

        System.out.println("Do you want to set a divisor? y/n:");
        response = input.next();
        if (response.equalsIgnoreCase("y")) {
            divisor = input.nextInt();
        }
        else {
            divisor = 2147483647;
        }

	    Long[][] mem = new Long[numIteration][numIteration];

	    for (int i = 0; i < numIteration; i++){
            Long[] temp = generate(a, b, genAFactor, genBFactor, divisor);
	        for (int j = 0; j < 2; j++){
	            mem[i][j] = temp[j];
            }

	        //update generators for the next iteration
            a = mem[i][0];
	        b = mem[i][1];
        }

	    //finally, compare values
        checker(mem);
    }

    public static Long[] generate(Long num1, Long num2, int genAFactor, int genBFactor, int divisor){
        Long genA = num1;
        Long genB = num2;

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
