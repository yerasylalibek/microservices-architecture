package kz.app.cart.shopping.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "_payment")
@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference_no")
    private int referenceNo;

    @Column(name = "payment_for")
    private String paymentFor;

    @Column(name = "amount_paid")
    private String amountPaid;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "paid_by")
    private String paidBy;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
