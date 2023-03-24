package h2tml.qlns.model;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ten;
    private String heso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHeso() {
        return heso;
    }

    public void setHeso(String heso) {
        this.heso = heso;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", heso='" + heso + '\'' +
                '}';
    }
}
