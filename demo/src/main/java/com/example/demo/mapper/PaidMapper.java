package com.example.demo.mapper;

import com.example.demo.entity.PaidForm;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;


@Component
public interface PaidMapper {
    // 执行插入操作

    @Select("select * from paidform")
    List<PaidForm> getPaidList();

    @Select("select * from paidform where `date` like #{date}")
    List<PaidForm> getPaidListByDate(@Param("date") String date);
    @Insert("INSERT INTO `paidform` (`date`, `type`, `price`, `detaildescription`, `tag`, `createdate`) VALUES (#{date}, #{type}, #{price}, #{detaildescription}, #{tag}, #{createdate})")
    Boolean addPaid(@Param("date") String date,
                    @Param("type") String type, // 注意：尽管这个参数在SQL语句中硬编码为'中餐'，但它在方法签名中仍然需要
                    @Param("price") Double price,
                    @Param("detaildescription") String detaildescription,
                    @Param("tag") Integer tag,
                    @Param("createdate") Timestamp createdate);

    @Update("UPDATE `paidform` SET `date` = #{date}, `type` = #{type}, `price` = #{price}, `detaildescription` = #{detaildescription}, `tag` = #{tag}, `createdate` = #{createdate} WHERE `id` = #{id}")
    Boolean updatePaid(@Param("id") Integer id, @Param("date") String date,
                    @Param("type") String type, // 注意：尽管这个参数在SQL语句中硬编码为'中餐'，但它在方法签名中仍然需要
                    @Param("price") Double price,
                    @Param("detaildescription") String detaildescription,
                    @Param("tag") Integer tag,
                    @Param("createdate") Timestamp createdate);

    @Delete("DELETE FROM `paidform` WHERE `id` = #{id}")
    Boolean deletePaid(@Param("id") Integer id);
}
