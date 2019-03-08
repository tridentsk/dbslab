package sample.model;
import javafx.beans.property.*;
public class Post {
    private SimpleIntegerProperty P_id;
    private SimpleStringProperty P_name;
    private SimpleIntegerProperty salary;
    private SimpleIntegerProperty yrs_of_exp_req;

    public Post(){
        this.P_id = new SimpleIntegerProperty();
        this.P_name = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
        this.yrs_of_exp_req = new SimpleIntegerProperty();
    }

    public int getP_id() {
        return P_id.get();
    }

    public void setP_id(int P_id){
        this.P_id.set(P_id);
    }

    public SimpleIntegerProperty P_idProperty(){
        return P_id;
    }

    public String getP_name() {
        return P_name.get();
    }

    public void setP_name(String P_name){
        this.P_name.set(P_name);
    }

    public SimpleStringProperty P_nameProperty(){
        return P_name;
    }

    public int getsalary() {
        return salary.get();
    }

    public void setsalary(int salary){
        this.salary.set(salary);
    }

    public SimpleIntegerProperty salaryProperty(){
        return salary;
    }

    public int getyrs_of_exp_req() {
        return yrs_of_exp_req.get();
    }

    public void setyrs_of_exp_req(int yrs_of_exp_req){
        this.yrs_of_exp_req.set(yrs_of_exp_req);
    }

    public SimpleIntegerProperty yrs_of_exp_reqProperty(){
        return yrs_of_exp_req;
    }
}
