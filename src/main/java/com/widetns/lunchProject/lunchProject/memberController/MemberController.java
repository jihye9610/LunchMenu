package com.widetns.lunchProject.lunchProject.memberController;

import com.widetns.lunchProject.lunchProject.Exception.BadRequestException;
import com.widetns.lunchProject.lunchProject.entity.Member;
import com.widetns.lunchProject.lunchProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @GetMapping(value ="/members/new")
    public String createForm(){
        return "createMemberForm";
    }

    @PostMapping(value ="/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setUserName(form.getUserName());
        member.setEmail(form.getEmail());
        member.setMemberId(form.getMemberId());
        member.setPassword(form.getPassword());

//        checkDuplicateId(member.getId());
        memberService.join(member);
        return "redirect:/home";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members =memberService.findAll();
        model.addAttribute("members",members);
        return "memberList";
    }

    @GetMapping("members/new/checkId")
    public ResponseEntity<?> checkDuplicateId(@RequestParam(value = "memberId")String memberId)throws BadRequestException {
        System.out.println(memberId);

        if(memberService.existsByMemberId(memberId) == true){
            throw new BadRequestException("이미 사용중인 아이디 입니다.");
        }
        else{
            return ResponseEntity.ok("사용 가능한 아이디입니다.");
        }
    }
}
