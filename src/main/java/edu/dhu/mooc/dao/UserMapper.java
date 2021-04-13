package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/12 15:39
 * @describe
 */

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from student")
    List<Student> getAll();

}
