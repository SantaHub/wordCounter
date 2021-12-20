package main;

import java.io.File;
import java.util.Scanner;

class ScanFile1{
    public static void main(String [] args) throws Exception {

        File f = new File("src/testfile.txt");
        Scanner scan = new Scanner(f);

        int wordCount = 0;

        while (scan.hasNextLine()){
//split the spaces:
            String s = scan.nextLine();
            String [] s_arr = s.split(" ");

            for(int i=0;i<s_arr.length ; i++){
                for(int j=0;j<s_arr.length ; j++){
                    if(s_arr[j].equals(s_arr[i]))
                        wordCount++;
                }
                System.out.println(s_arr[i] + "-" + wordCount);
            }

        }

    }

}