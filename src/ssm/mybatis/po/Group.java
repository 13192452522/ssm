package ssm.mybatis.po;

public class Group {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.id
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.userid
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.name
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_group.date
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    private String date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.id
     *
     * @return the value of t_group.id
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.id
     *
     * @param id the value for t_group.id
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.userid
     *
     * @return the value of t_group.userid
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.userid
     *
     * @param userid the value for t_group.userid
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.name
     *
     * @return the value of t_group.name
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.name
     *
     * @param name the value for t_group.name
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_group.date
     *
     * @return the value of t_group.date
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_group.date
     *
     * @param date the value for t_group.date
     *
     * @mbg.generated Mon Jun 11 17:54:05 CST 2018
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}