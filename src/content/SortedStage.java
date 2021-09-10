/*
 * Name: Shibrah Misbah
 * Student Number: 991593708 
 */
package content;

import java.util.Iterator;
import java.util.LinkedList;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SortedStage extends Stage{
    
    private TextArea txtDisplay = new TextArea();
    private Pane pane = new Pane(txtDisplay);
    private Scene scene = new Scene(pane, 200, 100);
    
    private LinkedList<Student> studentList = new LinkedList();
    
    public SortedStage(LinkedList<Student> studentList){
        
        this.studentList = studentList;
        displayList(studentList);
        setScene(scene);
        
    }
    
    public void displayList(LinkedList<Student> studentList){
        
        String display = new String();
        
        Iterator<Student> itList = studentList.iterator();
        
        while(itList.hasNext()){
            
            Student one = itList.next();
            display += one.getNumber() + "\t" + one.getMark() + "\n";
       
        }
        
        txtDisplay.setText(display);
    }
}
