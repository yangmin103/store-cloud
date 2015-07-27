package com.graby.store.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "sc_ship_order_cancel")
public class ShipOrderCancel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.id
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.userId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.orderCode
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String ordercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.orderId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.orderType
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String ordertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.cancelReason
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String cancelreason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sc_ship_order_cancel.createTime
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    private String createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.id
     *
     * @return the value of sc_ship_order_cancel.id
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
   // @Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.id
     *
     * @param id the value for sc_ship_order_cancel.id
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.userId
     *
     * @return the value of sc_ship_order_cancel.userId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.userId
     *
     * @param userid the value for sc_ship_order_cancel.userId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.orderCode
     *
     * @return the value of sc_ship_order_cancel.orderCode
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getOrdercode() {
        return ordercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.orderCode
     *
     * @param ordercode the value for sc_ship_order_cancel.orderCode
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.orderId
     *
     * @return the value of sc_ship_order_cancel.orderId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.orderId
     *
     * @param orderid the value for sc_ship_order_cancel.orderId
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.orderType
     *
     * @return the value of sc_ship_order_cancel.orderType
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getOrdertype() {
        return ordertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.orderType
     *
     * @param ordertype the value for sc_ship_order_cancel.orderType
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.cancelReason
     *
     * @return the value of sc_ship_order_cancel.cancelReason
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getCancelreason() {
        return cancelreason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.cancelReason
     *
     * @param cancelreason the value for sc_ship_order_cancel.cancelReason
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sc_ship_order_cancel.createTime
     *
     * @return the value of sc_ship_order_cancel.createTime
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sc_ship_order_cancel.createTime
     *
     * @param createtime the value for sc_ship_order_cancel.createTime
     *
     * @mbggenerated Wed Jul 22 15:41:19 CST 2015
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}