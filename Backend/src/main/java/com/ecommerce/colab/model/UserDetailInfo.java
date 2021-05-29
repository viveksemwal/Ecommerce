package com.ecommerce.colab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class UserDetailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "credit_card_no")
    private int creditCardNo;
    @Column(name = "credit_card_month")
    private int ccMonth;
    @Column(name = "credit_card_year")
    private int ccYear;

    @Column(name = "debit_card_no")
    private int debitCardNo;

    @Column(name = "debit_card_month")
    private int dcMonth;
    @Column(name = "debit_card_year")
    private int dcYear;

    @OneToOne(mappedBy = "details")
    private User user;

}
