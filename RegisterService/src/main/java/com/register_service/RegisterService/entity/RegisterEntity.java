package com.register_service.RegisterService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "register")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regid")
    private int regId;
    @Column(name = "fname",length = 20,nullable = false)
    private String firstName;
    @Column(name = "lname",length = 20,nullable = false)
    private String lastName;
    @Column(name = "email",length = 50,nullable = false)
    private String email;
    @Column(name = "contact",length = 12,nullable = false)
    private String contact;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "confirmpassword",nullable = false)
    private String confirmPassword;
    @ManyToOne
    @JoinColumn(name = "rid",nullable = false,referencedColumnName = "rid")
    private RoleEntity roleEntity;
}