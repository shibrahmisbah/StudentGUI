/*
 * Name: Shibrah Misbah
 * Student Number: 991593708 
 */
package content;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class StudentFile {
    
    
    public static void saveStatus(String fileName, LinkedList<Student> studentList) 
    throws IOException{
        
        //1. test to see if file exists using if statement
        /**if(!file.exists()){
         * file.createNewFile();
         * }
         */
        
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
       
        //Iterator<Type> name = linkedlist.iterator()
        Iterator<Student> students = studentList.iterator();
        
        //
        while(students.hasNext()){
          Student one = students.next();
          bw.write(one.getNumber() + " " + one.getStatus());
          bw.newLine();
        }
        
        /**make sure to close the BufferedWriter before the FileWriter.**/ 
        
        bw.close();
        fw.close();
    }
    
    public static void saveStatus(LinkedList<Student> studentList) throws IOException{
        
        FileWriter fw = new FileWriter("Student.dat");
        BufferedWriter bw = new BufferedWriter(fw);
        
        Iterator<Student> students = studentList.iterator();
        while(students.hasNext()){
          Student one = students.next();
          bw.write(one.getNumber() + " " + one.getStatus());
          bw.newLine();
        }
  
        bw.close();
        fw.close();
    }
}
