package com.widetns.lunchProject.lunchProject.memberController;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;

@Getter
@Setter
public class MemberForm {

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String memberId;
    @Column(nullable = false)
    private String password;

}
