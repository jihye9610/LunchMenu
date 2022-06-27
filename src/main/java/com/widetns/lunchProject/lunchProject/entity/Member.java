package com.widetns.lunchProject.lunchProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name ="member")
public class Member {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer userIdx;

        private String userName;

        private String email;

        private String memberId;

        private String password;

        private String id;
}
