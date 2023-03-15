/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbe3.primer1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author pedja
 */


public class DataOutputStream_Example {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        double[] prices = {19.99, 9.99};
        int[] units = {12, 8};
        String[] descs = {"Java T-shirt", "Java Mug"};

        DataOutputStream out = new DataOutputStream(
                new FileOutputStream("invoice1.txt"));
        for (int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeChars(descs[i]);
            out.writeChar('\n');
        }

        out.close();

//        Now, lets read out the data written
        double price;
        int unit;
        StringBuffer desc;
        double total = 0;
        DataInputStream in = new DataInputStream(
                new FileInputStream("invoice1.txt"));
        try {
            while (true) {
                price = in.readDouble();
                in.readChar();       //throws out the tab
                unit = in.readInt();
                in.readChar();       //throws out the tab
                char chr;
                desc = new StringBuffer(20);
                //Kraj reda je u Linuxu \n, u Windows-u \r\n
                String lineSepChars = System.getProperty("line.separator");
                //u svakakom slucaju poslednji karakter u stringu koji se vrati
                // pozivom System.getProperty("line.separator") bice onaj koji nam treba
                char lineSep = lineSepChars.charAt(lineSepChars.length() - 1);
                

                //i onda odbaci sve dok ne dodjes do nje, tako da isti kod radi i na Win i na Linux OS
                while ((chr = in.readChar()) != lineSep) {
                    if (lineSepChars.indexOf(chr) == -1)//dodaj samo ako procitan karakter nije deo separatora linije
                        desc.append(chr);
                }

                System.out.println("You've ordered " + unit + " units of "
                        + desc + " at $" + price);
                total = total + unit * price;
            }
        } catch (EOFException e) {
        }
/*
        Note the loop above is used to read the data from the DataInputStream. 
        Normally, when data is read, you see loops like this:


        while ((input = in.read()) != null) {
    
        . . .

        }

        The read method returns a value, null, which indicates that the end of the file has been reached. 

        Many of the DataInputStream read methods can't do this, because any value that could be returned to indicate the end of 
        file may also be a legitimate value read from the stream. 

        For example, suppose that you want to use -1 to indicate end of file.  Well, you can't, because -1 is a legitimate value
        that can be read from the input stream, using readDouble, readInt, or one of the other methods that reads numbers. 

        So DataInputStreams read methods throw an EOFException instead. When the EOFException occurs, the while (true) terminates.
        
        */

        
        System.out.println("For a TOTAL of: $" + total);
        in.close();

    }
}
