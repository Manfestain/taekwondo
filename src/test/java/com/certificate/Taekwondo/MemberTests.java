package com.certificate.Taekwondo;

import com.certificate.Taekwondo.dao.MemberDAO;
import com.certificate.Taekwondo.model.Member;
import com.certificate.Taekwondo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTests {
    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberService memberService;

    @Test
    public void testsMember() {
//        Member member = new Member();
//        member.setNumber("HGP20371098");
//        member.setId(1);
//        member.setName("王贵福");
//        member.setGender("男");
//        member.setPhone("13390018993");
//        member.setRank("七级会员");
//        member.setRights("送两次技术讲习会资格");
//        member.setPoints(50);
//        member.setDate(new Date());
//
//        memberDAO.updateMemberById(member);
//        Member member = memberDAO.selectMemberById(1);
//        Member member = memberDAO.selectMemberByNumber("HGP20371098");
        Member member = memberDAO.selectMemberByPhone("13390018993");
        System.out.println(member.toString());
    }
}
