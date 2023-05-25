package com.trainings.algorithms.arrays;

public class SumOfTwoIntegers {


    public int getSum(int a, int b) {
        char[] charA = new StringBuilder(Integer.toBinaryString(a)).reverse().toString().toCharArray();
        char[] charB = new StringBuilder(Integer.toBinaryString(b)).reverse().toString().toCharArray();

        StringBuilder arrayBuilder = new StringBuilder();
        char carryOver = '0';
        for (int i = 0; i < Math.max(charA.length, charB.length); i++) {
            char aBit = '0', bBit = '0';

            if(i < charA.length) {
                aBit = charA[i];
            }

            if(i < charB.length) {
                bBit = charB[i];
            }

            /*
                000 -> 0 0
                001 -> 1 0
                010 -> 1 0
                011 -> 0 1
                100 -> 1 0
                101 -> 0 1
                110 -> 0 1
                111 -> 1 1
             */

            if(carryOver == '0' && aBit == '0' && bBit == '0') {
                arrayBuilder.append("0");
            } else if(carryOver == '0' && (aBit == '1' || bBit == '1')) {
                arrayBuilder.append("1");
            } else if(carryOver == '0' && aBit == '1' && bBit == '1') {
                arrayBuilder.append("0");
                carryOver = '1';
            } else if(carryOver == '1' && aBit == '0' && bBit == '0') {
                arrayBuilder.append("1");
                carryOver = '0';
            } else if(carryOver == '1' && (aBit == '1' || bBit == '1')) {
                arrayBuilder.append("0");
            } else {
                arrayBuilder.append("1");
                carryOver = '1';
            }
        }

        if(carryOver =='1') {
            arrayBuilder.append("1");
        }

        return Integer.valueOf(arrayBuilder.reverse().toString(), 2);
    }
}
