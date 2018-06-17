package com.company;

public class WordPlay
{
    public static void main(String[] args)
    {
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(isVowel('e'));
    }

    public static boolean isVowel(char ch)
    {
        switch (Character.toLowerCase(ch))
        {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            default:
                return false;
        }
    }

    static private String replaceVowels(String phrase, char Ch)
    {
        StringBuilder rval = new StringBuilder();
        for(int i = 0; i < phrase.length() ; i++) {
            if (isVowel(phrase.charAt(i))) {
                rval.append(Ch);
            }
            else
            {
                rval.append(phrase.charAt(i));
            }
        }
            return rval.toString();
    }
    static private String emphasize(String phrase, char Ch)
    {
        StringBuilder rval = new StringBuilder();
        for(int i = 0; i < phrase.length() ; i++)
        {
            if(phrase.toLowerCase().charAt(i) == Ch)
            {
                if(i%2 == 0)
                {
                    rval.append('*');
                }
                else
                {
                    rval.append('+');
                }
            }
            else
            {
               rval.append(phrase.charAt(i));
            }
        }
        return rval.toString();
    }
}
