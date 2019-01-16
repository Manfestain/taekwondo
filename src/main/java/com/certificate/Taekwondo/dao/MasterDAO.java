package com.certificate.Taekwondo.dao;

import com.certificate.Taekwondo.model.Master;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MasterDAO {
    String TABLE_NAME = "master";
    String INSERT_FIELDS = "name, gender, age, photo_url, office, introduce";
    String SELECT_FILEDS = "id " + INSERT_FIELDS;

    // 插入机构成员信息
    @Insert({"(insert into", TABLE_NAME, "(", INSERT_FIELDS,
        ") values (#{name}, #{gender}, #{age}, #{photoUrl}, #{office}, #{introduce})"})
    int insertMaster(Master master);

    // 根据姓名查询成员信息
    @Select({"select", SELECT_FILEDS, "from", TABLE_NAME, "where name=#{name}"})
    List<Master> selectMasteByName(String name);

    // 修改成员信息
    @Update({"update", TABLE_NAME, "set ${fields_name}=#{fieldValue} where id=#{id}"})
    void updateMasterById(int id,
                          @Param("fields_name") String fielddsName,
                          @Param("fieldsValue") Object fieldsValue);
}
