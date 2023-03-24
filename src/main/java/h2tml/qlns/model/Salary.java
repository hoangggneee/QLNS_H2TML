package h2tml.qlns.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String  salary_name;

    private String salary_detail;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSalary_name() {
        return salary_name;
    }

    public void setSalary_name(String salary_name) {
        this.salary_name = salary_name;
    }

    public String getSalary_detail() {
        return salary_detail;
    }

    public void setSalary_detail(String salary_detail) {
        this.salary_detail = salary_detail;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary_name='" + salary_name + '\'' +
                ", salary_detail='" + salary_detail + '\'' +
                '}';
    }
}
