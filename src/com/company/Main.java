package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

  public static final int countLetter=10;

    public static void main(String[] args) {

        try {
            readPaper("1.txt", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
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


        //Последовательно сшить 5 файлов в один (файлы также ~100 байт).
        FileOutputStream FO = null;
        OutputStream out = null;

        StringBuilder Sb= new StringBuilder();
        try {
            // Files.readAllBytes(Paths.get("1.txt"));

            out = new BufferedOutputStream(new FileOutputStream("6.txt"));
            BufferedInputStream in1 = new BufferedInputStream(new FileInputStream("1.txt"));
            byte[] b= null;
            while (in1.read() != -1)
            {
              // НЕ ПОНЯТНО КАК СЧИТАТЬ СТРОКОВЫЙ ФАЙЛ BufferedInputStream'ОМ?
            };
            out.close();
            in1.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        StringBuilder sb = new StringBuilder();
        String line = null;
        try {


            BufferedReader br = new BufferedReader(new FileReader("1.txt"));

             while ((line = br.readLine())!=null)
             sb.append(line);

             ArrayList<BufferedReader> al = new  ArrayList();
            al.add(new BufferedReader(new FileReader("2.txt")));
            al.add(new BufferedReader(new FileReader("3.txt")));

            for (BufferedReader bb:al
                 )
            {
                while ((line = bb.readLine())!=null)
                sb.append(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------- ");
        System.out.println(sb.toString());


        // Записать в файл

        try (FileWriter writer = new FileWriter("6.txt",true);) {
        writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    private static String readPaper (String fname, int numb) throws Exception
    {
        String paper=null;
        RandomAccessFile raf = new RandomAccessFile(fname, "r");
        int seakNum = (countLetter * numb);
        raf.seek(seakNum);
        long point=0;
        String t = " ";
        int i;
        int b = raf.read();
        System.out.println("---- Чтение страницы № " + numb + ": ------- ");
        while ((b!=-1) && (point<((countLetter * numb)+countLetter)))
        {
            t = t + (char)b;
            b = raf.read();
            point = raf.getFilePointer();
        }
        System.out.println(t);
        System.out.println("--------------------------------------------------");


        return t;

    }


}


