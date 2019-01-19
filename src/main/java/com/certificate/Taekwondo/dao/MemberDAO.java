package com.certificate.Taekwondo.dao;

import com.certificate.Taekwondo.model.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberDAO {
    String TABLE_NAME = "member";
    String INSERT_FIELDS = "";
    String SELECT_FIELDS = "id " + INSERT_FIELDS;

    // 插入
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
             ") values (#{number}, #{name}, #{gender}, #{phone}, #{rank}, #{points}, #{rights}, #{date}"})
    int insertMember(Member member);

    // 查找
    @Select({"select", SELECT_FIELDS, "from where id=#{id}"})
    Member selectMemberById(int id);

    @Select({"select", SELECT_FIELDS, "from where phone=#{phone}"})
    Member selectMemberByPhone(String phone);

    @Select({"select", SELECT_FIELDS, "from where number=#{number}"})
    Member selectMemberByNumber(String number);

    // 更新
    @Update({"update", TABLE_NAME, "set ${fields_name}=#{fieldValue} where id=#{id}"})
    void updateCertificateById(@Param("id") int id,
                               @Param("fields_name") String fields_name,
                               @Param("fieldValue") Object fieldValue);

    // 删除
    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteCertificateById(int id);
}
