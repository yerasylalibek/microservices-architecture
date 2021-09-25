package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
