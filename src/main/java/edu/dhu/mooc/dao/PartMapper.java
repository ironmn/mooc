package edu.dhu.mooc.dao;

import edu.dhu.mooc.entity.Part;
import edu.dhu.mooc.entity.course.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    int deleteByPrimaryKey(String p_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    int insert(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    int insertSelective(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    Part selectByPrimaryKey(String p_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    int updateByPrimaryKeySelective(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table part
     *
     * @mbg.generated Mon Apr 12 15:50:40 CST 2021
     */
    int updateByPrimaryKey(Part record);

    /**
     * SQL:
     * select * from part where c_id = #{c_id};
     * @param c_id
     * @return
     */
    List<Part> getPartListByCourseId(@Param("c_id")String c_id);
}