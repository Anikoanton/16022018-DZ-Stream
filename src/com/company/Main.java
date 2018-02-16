package com.company;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here

        byte[] arr = {80, 25 ,100};
        ByteArrayInputStream in = new ByteArrayInputStream(arr);
        int x;
        while ((x=in.read())!= -1)
        {System.out.println(x + " ");}

        byte j=1;

        // записать массив байт
        byte [] bwrite = new byte[50];
        byte [] bread = new byte[50];
        for (int i=0; i<bwrite.length;i++)
        {
            bwrite[i]=(byte) (j*2);
            j++ ;
        }
        FileOutputStream fout = null;
        FileInputStream fin= null;
        try {
            fout=new FileOutputStream("new.txt");
            fout.write(bwrite);
            fout.close();
        } catch (IOException e)
        {e.printStackTrace();}
        finally {
            try {
                fout.close();
            } catch (IOException e)
            {e.printStackTrace();}
        }
// Задание 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        try {
            fin=new FileInputStream("new.txt");
            int count=fin.read(bread);
            fin.close();
        } catch (Exception e)
        {e.printStackTrace();}
        finally {
            try {
                fin.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        for (byte a:bread
                ) {System.out.print(a + "; ");

        }

    }
}


