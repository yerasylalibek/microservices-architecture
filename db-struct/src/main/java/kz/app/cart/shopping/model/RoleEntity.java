package kz.app.cart.shopping.model;


import kz.app.cart.shopping.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "_roles")
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    Long id;

    @Column(name = "role_name")
    private UserRoles roleName;

    @Column(name = "description")
    private String description;
}
