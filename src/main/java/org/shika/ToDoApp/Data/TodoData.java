package org.shika.ToDoApp.Data;

public class TodoData {

    private String DisplayName;
    private String Description;
    private String Term;
    private boolean Completion;

    public TodoData(){

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

    @Override
    public String toString(){
        return "[名前]: " + DisplayName + " [説明]: " + Description + " [期限]: " + Term + " [完了]: " + Completion;
    }
}
