package org.shika.ToDoApp.Data;

public class TodoData {

    private int ID;
    private String DisplayName;
    private String Description;
    private String Term;
    private boolean Completion;

    public TodoData(){

    }

    public void setID(int ID){
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setDisplayName(String DisplayName){
        this.DisplayName = DisplayName;
    }

    public String getDisplayName(){
        return DisplayName;
    }

    public void setDescription(String Description){
        this.Description = Description;
    }

    public String getDescription(){
        return Description;
    }

    public void setTerm(String Term){
        this.Term = Term;
    }

    public String getTerm(){
        return Term;
    }

    public void setCompletion(boolean Completion){
        this.Completion = Completion;
    }

    public boolean isCompletion(){
        return Completion;
    }
}
