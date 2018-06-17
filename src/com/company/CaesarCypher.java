package com.company;

import org.junit.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCypher
{
    public static void main(String args[]) throws IOException
    {
        testCaesar();
        System.out.println(encrytpTwoKeys("First Legion",23,17));
        Scanner sc = new Scanner(System.in);
        System.out.println("Define the cypher move for Ceasar cypher with integer : ");
        int key = sc.nextInt();

        System.out.println("Proivde message : ");
        sc = new Scanner(System.in);
        String message = sc.nextLine();

        System.out.println(encrypt(message,key));
    }

    private static String encrypt(String message, int key)
    {
        String basicAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = basicAlphabet.substring(key);
        shiftedAlphabet += basicAlphabet.substring(0,key);

        StringBuilder rval = new StringBuilder();
        for (int i = 0 ; i < message.length() ; i++ )
        {

            char currChar = message.charAt(i);
            if (basicAlphabet.indexOf((Character.toUpperCase(currChar))) != -1)
            {
                if (Character.isUpperCase(currChar))
                {
                    rval.append(shiftedAlphabet.charAt(basicAlphabet.indexOf(currChar)));
                }
                if (Character.isLowerCase(currChar))
                {
                    rval.append(Character.toLowerCase(shiftedAlphabet.charAt(basicAlphabet.indexOf(Character.toUpperCase(currChar)))));
                }
            }
            else
                {
                rval.append(currChar);
            }
        }
        return rval.toString();

    }
    private static void testCaesar() throws IOException
    {
        String filePath = "C:/Users/Piotrek/IdeaProjects/ruszGlowo/src/com/company/cypher.txt";
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        try
        {
            String message = "";
            do {
                message = message + br.readLine();
            } while (br.readLine() != null);
            System.out.println(encrypt(message, 16));
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
        finally
        {
            br.close();
        }
    }
    private static String encrytpTwoKeys(String input, int key1, int key2)
    {
        String basicAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = basicAlphabet.substring(key1);
        shiftedAlphabet1 += basicAlphabet.substring(0,key1);

        String shiftedAlphabet2 = basicAlphabet.substring(key2);
        shiftedAlphabet2 += basicAlphabet.substring(0,key2);

        StringBuilder rval = new StringBuilder();
        String alphabet = "";
        for (int i = 0 ; i < input.length() ; i++ )
        {
            if (i %2 == 0) {
                alphabet = shiftedAlphabet1;
            }
            else
            {
                alphabet = shiftedAlphabet2;
            }
            char currChar = input.charAt(i);
            if (basicAlphabet.indexOf((Character.toUpperCase(currChar))) != -1)
            {
                if (Character.isUpperCase(currChar))
                {
                    rval.append(alphabet.charAt(basicAlphabet.indexOf(currChar)));
                }
                if (Character.isLowerCase(currChar))
                {
                    rval.append(Character.toLowerCase(alphabet.charAt(basicAlphabet.indexOf(Character.toUpperCase(currChar)))));
                }
            }
            else
            {
                rval.append(currChar);
            }
        }
        return rval.toString();
    }
}
