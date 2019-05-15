//package com.piggymetrics.auth.domain;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//import org.springframework.security.core.GrantedAuthority;
//
//@Entity
//public class Role implements GrantedAuthority {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    //setter getter
//    
//    @Override
//    public String getAuthority() {
//        return name;
//    }
//    
//    @Override
//    public String toString() {
//        return name;
//    }
//}