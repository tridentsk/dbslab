package sample.model;

import javafx.beans.property.*;

public class Crew {
    private SimpleIntegerProperty ID;
    private SimpleStringProperty E_name;
    private SimpleIntegerProperty age;
    private SimpleIntegerProperty yrs_of_exp;
    private SimpleStringProperty sex;
    private SimpleIntegerProperty S_id;
    private SimpleIntegerProperty F_id;
    private SimpleIntegerProperty P_id;

    public Crew(){
        this.ID = new SimpleIntegerProperty();
        this.E_name = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
        this.yrs_of_exp = new SimpleIntegerProperty();
        this.sex = new SimpleStringProperty();
        this.S_id = new SimpleIntegerProperty();
        this.F_id = new SimpleIntegerProperty();
        this.P_id = new SimpleIntegerProperty();
    }
    //ID
    public int getID() {
        return ID.get();
    }

    public void setID(int CrewId){
        this.ID.set(CrewId);
    }

    public SimpleIntegerProperty IDProperty(){
        return ID;
    }

    public String getE_Name() {
        return E_name.get();
    }

    public void setE_Name(String name){
        this.E_name.set(name);
    }

    public SimpleStringProperty E_NameProperty() {
        return E_name  ;
    }

    public int getage() {
        return age.get();
    }

    public void setage(int age){
        this.age.set(age);
    }

    public SimpleIntegerProperty ageProperty(){
        return age;
    }

    public int getyrs_of_exp() {
        return ID.get();
    }

    public void setyrs_of_exp(int yrs){
        this.yrs_of_exp.set(yrs);
    }

    public SimpleIntegerProperty yrs_of_expProperty() { return yrs_of_exp; }

    public String getsex() {
        return E_name.get();
    }

    public void setsex(String sex){
        this.sex.set(sex);
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public int getS_id() {
        return ID.get();
    }

    public void setS_id(int sid){
        this.S_id.set(sid);
    }

    public SimpleIntegerProperty S_idProperty(){
        return S_id;
    }

    public int getF_id() {
        return ID.get();
    }

    public void setF_id(int fid){
        this.F_id.set(fid);
    }

    public SimpleIntegerProperty F_idProperty(){
        return F_id;
    }

    public int getP_id() {
        return ID.get();
    }

    public void setP_id(int pid){
        this.P_id.set(pid);
    }

    public SimpleIntegerProperty P_idProperty(){
        return P_id;
    }
}
