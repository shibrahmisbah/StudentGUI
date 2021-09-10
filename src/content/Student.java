/*
 * Name: Shibrah Misbah
 * Student Number: 991593708 
 */
package content;

public class Student implements Comparable<Student> {
    
    private int number;
    private int mark;
    private String status;
    
    //set by constructor
    public Student(int number){
        this.number = number;
    }
    
    //get method for number
    public int getNumber(){
        return this.number;
    }
    
    //set method for mark 
    public void setMark(int mark){
        this.mark = mark;
    }
    
    //get method for mark
    public int getMark(){
        return this.mark;
    }
    
    //get method for status
    public String getStatus(){
        calculateStatus();
        return this.status;
    }
    
    public void calculateStatus(){
        
        if(this.mark < 50 )
        {
            this.status = "Fail";
        }
        else  
        {
            this.status = "Pass";
        }
    }
    
    /** method to sort list in a descending order
     * compares the marks of objects
     * moves mark down if mark is found to be lower than one.mark 
     **/
    
    @Override
    public int compareTo(Student one) {
        
        if(this.mark < one.mark){
            return 1;
        }else if(this.mark > one.mark){
            return -1;
        }else{
            return 0;
        }
    }
}
