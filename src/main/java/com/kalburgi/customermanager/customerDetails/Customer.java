package com.kalburgi.customermanager.customerDetails;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , updatable = false)
    private Long id;
    private String name;
    private String phone;
    @Column(name = "created_time" , updatable = false)
    private Date createdTime;
    private String city;

    private boolean enabled;

    @Column(name="verfification_code" , updatable = false)
    private String verificationCode;
    private String email;
    private String imageUrl;
 }
