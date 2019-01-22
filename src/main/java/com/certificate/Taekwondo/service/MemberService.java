package com.certificate.Taekwondo.service;

import com.certificate.Taekwondo.dao.MemberDAO;
import com.certificate.Taekwondo.model.Member;
import com.certificate.Taekwondo.utils.DateUtil;
import com.certificate.Taekwondo.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;

    // 会员权益
    public static String rankMap(String rank) {
        Map<String, Object> rankContent = new HashMap<String, Object>(){{
            put("nine", "九段联盟专属高级跆拳道服一套");
            put("eight", "送两次技术讲习会资格");
            put("seven", "赴韩国跆拳道研修及访问旅游费用（不包含机票及签证）");
            put("six", "赴韩国跆拳道研修及访问旅游费用加往返机票（签证自理）");
            put("five", "举办技术讲习会资格，任命韩国京畿道跆拳道协会中国市（普通地级市）支部长");
            put("four", "举办技术讲习会资格，任命韩国京畿道跆拳道协会中国市（省会级城市及大城市）支部长");
            put("three", "有资格承办九段联盟杯跆拳道赛事，任命韩国京畿道跆拳道协会中国省（或直辖市级）支部长");
            put("two", "无");
            put("one", "无");
        }};
        return rankContent.get(rank).toString();
    }

    // 添加单个会员
    public Map<String, String>addSingleMember(String number,
                                        String name,
                                        String gender,
                                        String phone,
                                        String rank,
                                        int points,
                                        String rights,
                                        Date date) {
        Map<String, String> map = new HashMap<String, String>();

        Member member = new Member();
        member.setNumber(number);
        member.setName(name);
        member.setGender(gender);
        member.setPhone(phone);
        member.setRank(rank);
        member.setPoints(points);
        member.setRights(rankMap(rank));
        member.setDate(new Date());

        map.put("msg", "会员添加成功");
        memberDAO.insertMember(member);
        return map;
    }

    // 解析excel文件，添加多个member
    public Map<String, String> addExcelMember(MultipartFile file) {
        Map<String, String> map = new HashMap<String, String>();
        List<List> list = ExcelUtil.readExcel(file);
        Member member = new Member();
        int memberNum;
        for(memberNum=0; memberNum < list.size(); ++memberNum) {
            List<String> info = new ArrayList<String>();
            member.setName(info.get(0));
            member.setGender(info.get(1));
            member.setPhone(info.get((2)));
            member.setNumber(info.get(2));
            member.setPoints(Integer.parseInt(info.get(3)));
            member.setRank(info.get(4));
            member.setRights(rankMap(info.get(4)));
            member.setDate(DateUtil.stringToDate(info.get(5)));   // 入会时间
            memberDAO.insertMember(member);
        }
        if(memberNum == list.size()) {
            map.put("msg", "会员信息录入成功！");
        } else {
            map.put("msg", "会员信息录入失败！");
        }
        return map;
    }

    // 查询会员，只能通过id、number和phone查询
    public Member selectMemberById(int id) {
        return memberDAO.selectMemberById(id);
    }
    public Member selectMemberByName(String name) {
        return memberDAO.selectMemberByNumber(name);
    }
    public Member selectMemberByPhone(String phone) {
        return memberDAO.selectMemberByPhone(phone);
    }

    // 更新会员信息
    public Map<String, String> updateMember(int id,
                                            String name,
                                            String gender,
                                            String phone,
                                            String rank,
                                            int points) {
        Map<String, String> map = new HashMap<String, String>();
        Member member = new Member();
        member.setId(id);
        member.setName(name);
        member.setGender(gender);
        member.setPhone(phone);
        member.setRank(rank);
        member.setPoints(points);
        member.setRights(rankMap(rank));

        memberDAO.updateMemberById(member);
        map.put("msg", "会员信息更新成功");
        return map;
    }

}
