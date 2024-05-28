package com.example.blog.domain.member.Controller;

import com.example.blog.domain.member.Service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid SignForm signForm) {

        memberService.signup(signForm.getUsername(), signForm.getPassword(), signForm.getNickname(), signForm.getEmail());

        return "redirect:/member/login";
    }

    @Setter
    @Getter
    @ToString
    public static class SignForm {
        @NotBlank
        @Length(min = 3)
        private String username;

        @NotBlank
        @Length(min = 4)
        private String password;

        @NotBlank
        @Length(min = 4)
        private String password_confirm;

        @NotBlank
        @Length(min = 3)
        private String nickname;

        @NotBlank
        @Length(min = 4)
        private String email;
    }
}
