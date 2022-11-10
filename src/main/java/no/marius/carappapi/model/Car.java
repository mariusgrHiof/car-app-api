package no.marius.carappapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String make;
    private String model;
    private int hp;
    private String imageUrl;

    public Car(){}
    public Car(Long id, String make, String model, int hp, String imageUrl) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.hp = hp;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", hp=" + hp +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
