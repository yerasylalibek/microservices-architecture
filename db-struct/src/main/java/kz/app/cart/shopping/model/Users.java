package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "_users")
@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String username;
}
