package com.certificate.Taekwondo.dao;

import com.certificate.Taekwondo.model.Certificate;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CertificateDAO {
    String TABLE_NAME = "certificate";
    String INSERT_FIELDS = "number, name, institution, grade, birthday, examiner, date";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    // 插入整条数据
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{number}, #{name}, #{institution}, #{grade}, #{birthday}, #{examiner}, #{date})"})
    int insertCertificate(Certificate certificate);

    // 根据证书编号查询
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where number=#{number}"})
    Certificate selectCertificateByNumber(String number);

    // 根据姓名查询
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where name=#{name}"})
    List<Certificate> selectCertificateByName(String name);

    // 修改数据
    @Update({"update", TABLE_NAME, "set ${fields_name}=#{fieldValue} where id=#{id}"})
    void updateCertificateSingleById(@Param("id") int id,
                               @Param("fields_name") String fields_name,
                               @Param("fieldValue") Object fieldValue);

    @Update({"update", TABLE_NAME, "set name=#{name}, institution=#{institution}, grade=#{grade}, birthday=#{birthday}, examiner=#{examiner}, date=#{date} where number=#{number}"})
    void updateCertificateById(@Param("number") String number,
                               @Param("name") String name,
                               @Param("grade") String grade,
                               @Param("birthday") Date birthday,
                               @Param("examiner") String examiner,
                               @Param("date") Date date,
                               @Param("institution") String institution);

    // 根据编号删掉一条
    @Delete({"delete from", TABLE_NAME, "where id=#{id}"})
    void deleteCertificateById(int id);

    // 统计数据
    @Select({"select count(*) from certificate"})
    int countAllData();

}
