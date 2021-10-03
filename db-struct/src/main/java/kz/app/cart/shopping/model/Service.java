package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "_vendor")
@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long service_id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "reference_no")
    private String referenceNo;

    @Column(name = "service_detail")
    private String serviceDetail;

    @Column(name = "service_fee")
    private String serviceFee;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
