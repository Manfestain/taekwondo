package com.certificate.Taekwondo.service;

import com.certificate.Taekwondo.dao.MemberDAO;
import com.certificate.Taekwondo.model.Member;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;

    // 添加会员
    public Map<String, String>addMember(String number,
                                        String name,
                                        String gender,
                                        String phone,
                                        String rank,
                                        int points,
                                        String rights) {
        Map<String, String> map = new HashMap<String, String>();
        String nineRank = "九段联盟专属高级跆拳道服一套";
        String eightRank = "送两次技术讲习会资格";
        String sevenRank = "赴韩国跆拳道研修及访问旅游费用（不包含机票及签证）";
        String sixRank = "赴韩国跆拳道研修及访问旅游费用加往返机票（签证自理）";
        String fiveRank = "举办技术讲习会资格，任命韩国京畿道跆拳道协会中国市（普通地级市）支部长";
        String fourRank = "举办技术讲习会资格，任命韩国京畿道跆拳道协会中国市（省会级城市及大城市）支部长";
        String threeRank = "有资格承办九段联盟杯跆拳道赛事，任命韩国京畿道跆拳道协会中国省（或直辖市级）支部长";
        String twoRank = "无";
        String oneRank = "无";
        Map<String, String> rankContent = new HashMap<String, String>(){{
            put("nine", nineRank);
            put("eight", eightRank);
            put("seven", sevenRank);
            put("six", sixRank);
            put("five", fiveRank);
            put("four", fourRank);
            put("three", threeRank);
            put("two", twoRank);
            put("one", oneRank);
        }};

        Member member = new Member();
        member.setNumber(number);
        member.setName(name);
        member.setGender(gender);
        member.setPhone(phone);
        member.setRank(rank);
        member.setPoints(points);
        member.setRights(convertToCode(rank, rankContent));

        map.put("msg", "会员添加成功");
        memberDAO.insertMember(member);
        return map;
    }

    // 字符串转代码
    public static Object convertToCode(String jexlExp,Map<String,Object> map){
        JexlEngine jexl=new JexlEngine();
        Expression e = jexl.createExpression(jexlExp);
        JexlContext jc = new MapContext();
        for(String key:map.keySet()){
            jc.set(key, map.get(key));
        }
        if(null==e.evaluate(jc)){
            return "";
        }
        return e.evaluate(jc);
    }

}
