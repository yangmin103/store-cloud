package com.graby.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sc_process")
public class Process {

    private Integer id;

    
    private String code;

    
    private String type;

    
    private String createtime;

    
    private String plantime;

    private String servicetype;

   
    private Integer planqty;

   
    private String remark;

   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.id
     *
     * @param id the value for sc_process.id
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.code
     *
     * @return the value of sc_process.code
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.code
     *
     * @param code the value for sc_process.code
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.type
     *
     * @return the value of sc_process.type
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.type
     *
     * @param type the value for sc_process.type
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.createTime
     *
     * @return the value of sc_process.createTime
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.createTime
     *
     * @param createtime the value for sc_process.createTime
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.planTime
     *
     * @return the value of sc_process.planTime
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getPlantime() {
        return plantime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.planTime
     *
     * @param plantime the value for sc_process.planTime
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setPlantime(String plantime) {
        this.plantime = plantime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.serviceType
     *
     * @return the value of sc_process.serviceType
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getServicetype() {
        return servicetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.serviceType
     *
     * @param servicetype the value for sc_process.serviceType
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.planQty
     *
     * @return the value of sc_process.planQty
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public Integer getPlanqty() {
        return planqty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.planQty
     *
     * @param planqty the value for sc_process.planQty
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setPlanqty(Integer planqty) {
        this.planqty = planqty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_process.remark
     *
     * @return the value of sc_process.remark
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_process.remark
     *
     * @param remark the value for sc_process.remark
     *
     * @mbggenerated Thu Jul 23 15:06:27 CST 2015
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}