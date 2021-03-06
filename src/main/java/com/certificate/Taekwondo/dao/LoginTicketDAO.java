package com.certificate.Taekwondo.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Mapper
public interface LoginTicketDAO {
    String TABLE_NAME = "login_ticket";
    String INSERT_FIELDS = "user_id, expired, status, ticket";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId}, #{expired}, #{status}, #{ticket})"})
    int addTicket(LoginTicket ticket);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id=#{userId}"})
    LoginTicket selectByUserId(int userId);

    @Update({"update", TABLE_NAME, "set status=#{status}, ticket=#{ticket}, expired=#{expired} where user_id=#{userId}"})
    void updateStatus(@Param("ticket") String ticket,
                      @Param("status") int status,
                      @Param("expired") Date expired,
                      @Param("userId") int userId);

    @Update({"update", TABLE_NAME, "set status=#{status} where ticket=#{ticket}"})
    void updateStatusCode(@Param("ticket") String ticket,
                      @Param("status") int status);

}
