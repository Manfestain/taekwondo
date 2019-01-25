package com.certificate.Taekwondo.dao;

import com.certificate.Taekwondo.model.Certificate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CertificateDAO {
    String TABLE_NAME = "certificate";
    String INSERT_FIELDS = "number, name, institution, rank, birthday, examiner, date";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    // 插入整条数据
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{number}, #{name}, #{institution}, #{rank}, #{birthday}, #{examiner}, #{date})"})
    int insertCertificate(Certificate certificate);

    // 根据证书编号查询
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where number=#{number}"})
    Certificate selectCertificateByNumber(String number);

    // 根据姓名查询
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where name=#{name}"})
    List<Certificate> selectCertificateByName(String name);

    // 修改数据
    @Update({"update", TABLE_NAME, "set ${fields_name}=#{fieldValue} where id=#{id}"})
    void updateCertificateById(@Param("id") int id,
                               @Param("fields_name") String fields_name,
                               @Param("fieldValue") Object fieldValue);

    // 根据编号删掉一条
    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteCertificateById(int id);

}
