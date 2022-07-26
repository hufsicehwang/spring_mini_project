package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        System.out.println(form.getMessage());
        Member member = new Member();
        member.setName(form.getName());
        member.setTeam(form.getTeam());
        member.setTitle(form.getTitle());
        member.setText(form.getMessage());
        member.setRegisterTime(LocalDateTime.now());

        memberService.join(member);

        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) {
        System.out.println("GET!!!!!!!!!!!!!");
        List<Member> members = memberService.findMembers();
        System.out.println("GET!!!!!!!!!!!!!, ,members : "+members.toString());
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @GetMapping("/members/detail")
    public String listDetail(@RequestParam int id, Model model) throws Exception {
        System.out.println("detail, id : "+id+"!!!!!!!!!!!");
        Optional<Member> members = memberService.findOne(id);
        System.out.println("detail!!!!!!!!!!!!!, ,members : "+members.toString());
        model.addAttribute("members", members);
        return "members/memberListDetail";
    }

}
