/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezbe3.primer1;

import java.io.*;
import java.io.Serializable;  
/**
 *
 * @author pedja
 */
class Student implements Serializable {

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Serialization_Example {

    public static void main(String args[]) throws Exception {
        Student s1 = new Student(211, "Milan Jovanovic");

        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(s1);
        out.flush();
        System.out.println("Successfully serialized student " + s1.name);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
        Student s = (Student) in.readObject();
        System.out.println("Deserialized student:" + s.id + " " + s.name);

        in.close();
        
        
    }
}
