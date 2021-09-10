/*
 * Name: Shibrah Misbah
 * Student Number: 991593708 
 */
package studentgui;

import content.SortedStage;
import content.Student;
import content.StudentFile;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
    
    LinkedList<Student> studentList = new LinkedList();
    
    TextField txtNumber = new TextField();
    Label lblNumber = new Label("Student Number: ");
    
    TextField txtMark = new TextField();
    Label lblMark = new Label("Student Mark: ");
    
    Button btnAdd = new Button("Add");
    Button btnSort = new Button("Sort");
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Scene scene = new Scene(studentPane(), 500,500);
        stage.setScene(scene);
        
        //call AddStudent, EndProgram, SortStudent 
        
        btnAdd.setOnAction(new AddStudent());  
        stage.setOnCloseRequest(new EndProgram());
        btnSort.setOnAction(new SortStudent());
        
        stage.show();
    }
    
    public GridPane studentPane(){
        
        GridPane pane = new GridPane();

        pane.add(lblNumber,0,0); 
        pane.add(txtNumber,1,0); 
        
        pane.add(lblMark,0,1); 
        pane.add(txtMark,1,1);
        
        pane.add(btnAdd,0,2); 
        pane.add(btnSort,1,2); 
        return pane;
    }
    
    public class AddStudent implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            
            Alert error = new Alert(Alert.AlertType.ERROR);
            Student one = new Student(Integer.parseInt(txtNumber.getText()));
            
            if(checkID(Integer.parseInt(txtNumber.getText()), studentList) == false 
                || checkMark(Integer.parseInt(txtMark.getText()), studentList) == false){
                error.show();
                error.setContentText("Error: ID Already exists or Invalid Mark");
                studentList.remove(one);
                txtNumber.clear();
                txtMark.clear();
                
            }else{
                one.setMark(Integer.parseInt(txtMark.getText()));
                studentList.add(one);
                txtMark.clear();
                txtNumber.clear();
                txtNumber.requestFocus();
            }
        }
    }
    
    
    public class EndProgram implements EventHandler<WindowEvent>{

        @Override
        public void handle(WindowEvent b) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Data Saved - Program Ending");
            alert.show();
            try{
            StudentFile.saveStatus(studentList);
            
            }catch(IOException e){
                Alert alertErr = new Alert(Alert.AlertType.ERROR);
                alertErr.setContentText("Data Not Saved");
                alertErr.setContentText(e.toString());
                alertErr.show();
            }
        }
    }
    
     public class SortStudent implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
                Collections.sort(studentList);
                SortedStage stage = new SortedStage(studentList);
                stage.show();       
        } 
     }
     
      public boolean checkID(int number, LinkedList<Student> list) {
         
        boolean isValid = true;
    
        for(Student student : list){
            
            if(number == student.getNumber()){
               
                isValid = false;
            } 
        }  
        return isValid;
    }
      
      public boolean checkMark(int mark, LinkedList<Student> list){
          boolean isValid = true;
          
          for(Student student : list){
              if(mark < 0 || mark > 100){
                  
                  isValid = false;
              }     
          }
          
          return isValid;
      }
    
     public static void main(String[] args) {
        
         Application.launch(args);
    }
}
