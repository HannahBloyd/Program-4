/*
 * Create a spell checker
 * using Linked Lists
 * 
 */
package lab6;

import java.util.*;
import java.io.*;

/**
 *
 * @author Hannah Bloyd
 */
public class Prg4 {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        int wordsFound=0, wordsNotFound=0;
        long compsFound=0, compsNotFound=0;
        MyLinkedList[] dictionary = new MyLinkedList[26];
        for (int i = 0; i < dictionary.length; i++) 
            dictionary[i] = new MyLinkedList<String>(); // each array element contains a new MyLinkedList 
        
        
        
        try{
            
            File in = new File("random_dictionary.txt");
            Scanner scan = new Scanner(in);
            
            while(scan.hasNext()){
                String s = scan.next();
                s=s.toLowerCase();
                while (s.charAt(s.length()-1)-97 < 0 || s.charAt(s.length()-1)-97 > 25)
                    s= s.substring(0, s.length()-1);
                dictionary[s.charAt(0)-97].add(s);
                
            }
            
            
            
            in = new File("oliver.txt");
            scan = new Scanner(in);
            
            while(scan.hasNext()){
                String s = scan.next();
                s=s.toLowerCase();
                
                
                while (s.charAt(0)-97 < 0 || s.charAt(0)-97 > 25){
                    
                    s= s.substring(1);
                    
                    if (s.length() == 0){
                        s = scan.next();
                        
                        
                    }//if
                    
                    
                }//while s.charat
                
               /*for(int i=0; i<s.length(); i++){
                if (s.charAt(i) < 0 || s.charAt(i) > 25)
                   s=s.substring(0, i) + s.substring(i+1);
               }   */ 
                int[] count = new int[1];
                count[0]=0;
                if (dictionary[s.charAt(0)-97].contains(s, count)) {
                    
                    wordsFound++;
                    compsFound += count[0];
                    
                } 
                else {
                    wordsNotFound++;
                    compsNotFound += count[0];
                    //System.out.println("count2 " + count[0]);
                }
                
                
            }//while scan.hasnext
            
            System.out.println("words found " + wordsFound);
            System.out.println("words not found " + wordsNotFound);
            System.out.println("Comps Found " + compsFound);
            System.out.println("CompsNotFound " + compsNotFound);
            
            double avgcompsfound = 0, avgcompsnotfound = 0;
            avgcompsfound = compsFound/wordsFound;
            avgcompsnotfound = compsNotFound/wordsNotFound;
            
            System.out.println("Average comps for words found " + avgcompsfound);
            System.out.println("Average comps for words not found " + avgcompsnotfound);
        }//try
        catch (Exception e){
            e.printStackTrace();
            
        } //catch
    }//main
    
}//class
