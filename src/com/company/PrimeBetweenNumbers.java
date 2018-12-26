package com.company;

public class PrimeBetweenNumbers {
    public static int returnPrimeBetweenNumbers(int lowestNumber, int highestNumber){
        boolean foundPrimeNumber;
        int primeNumber = 0;
        for(int i = highestNumber - 1; i > lowestNumber; i--)
        {
            if(PrimeUtils.isPrime(i))
            {
                primeNumber = i;
                break;
            }

        }
        return primeNumber;
    }


}

