package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "_vendor")
@Entity
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_contact_person")
    private String companyContactPerson;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "company_contact_number")
    private String companyContactNumber;

    @Column(name = "company_website")
    private String companyWebsite;

    @Column(name = "company_profile")
    private String companyProfile;

    @Column(name = "vendor_username")
    private String vendorUsername;

    @Column(name = "vendor_password")
    private String vendorPassword;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
