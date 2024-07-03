package com.icev.mobile.tea.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private GenderType gender;

    private String city;

    private String state;

    private AnswerEnum isASD;

    private AnswerEnum knowSomeoneWithASD;

    private Boolean deleted;

    private Date createdAt;

    private Date updateAt;
}
