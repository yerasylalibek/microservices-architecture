package kz.app.cart.shopping.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "_users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "middle_name")
    private String middleName;

    @Lob
    @Column(name = "avatar")
    private byte[] avatar;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "contact")
    private String contact;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "_user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @Column(name = "status")
    private String status;
}
