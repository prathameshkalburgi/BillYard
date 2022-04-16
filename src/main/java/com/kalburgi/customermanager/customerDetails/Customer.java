package com.kalburgi.customermanager.customerDetails;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="customer_details")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private Long id;
    private String name;
    @Size(min = 10, max = 10, message = "Phone number need to have only 10 numbers")
    private String phone;
    @Column(name = "created_time" , updatable = false)
    private Date createdTime;
    private String city;

    private boolean enabled;

    @Column(name="verfification_code" , updatable = false)
    private String verificationCode;
    private String email;
    private String imageUrl;
    @Column(nullable = false , updatable = false)
    private String customerCode;
 }
