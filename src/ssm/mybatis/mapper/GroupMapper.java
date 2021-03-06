package ssm.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.mybatis.po.Group;
import ssm.mybatis.po.GroupExample;

public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    long countByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    int deleteByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    int insertSelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    List<Group> selectByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_group
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);
}