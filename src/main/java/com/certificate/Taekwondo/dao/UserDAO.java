package com.certificate.Taekwondo.dao;

import com.certificate.Taekwondo.model.Member;
import com.certificate.Taekwondo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSERT_FIELDS = "username, password, salt";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    // 插入
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username}, #{password}, #{salt})"})
    int insertUser(User user);

    // 查找
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where username=#{useranme}"})
    User selectUserByUsername(String username);
}
