package cn.kgc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: spring_data_jpa->Linkman
 * @description: 联系人实体类

 **/

@Entity
@Table(name = "tb_linkman")
public class Linkman {
    /**
     * 联系人编号(主键)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Integer lkmId;

    /**
     * 联系人姓名
     */
    @Column(name = "lkm_name")
    private String lkmName;

    /**
     * 联系人性别
     */
    @Column(name = "lkm_gender")
    private String lkmGender;

    /**
     * 联系人手机
     */
    @Column(name = "lkm_phone")
    private String lkmPhone;

    /**
     * 联系人办公室电话
     */
    @Column(name = "lkm_mobile")
    private String lkmMobile;

    /**
     * 联系人邮箱
     */
    @Column(name = "lkm_email")
    private String lkmEmail;

    /**
     * 联系人职位
     */
    @Column(name = "lkm_position")
    private String lkmPosition;

    /**
     * 联系人备注
     */
    @Column(name = "lkm_memo")
    private String lkmMemo;

    /**
     * 配置多对多
     * 关联的另一方属性名
     */
    @ManyToMany(mappedBy = "linkmens")
    private Set<Customer> customer=new HashSet<Customer>();



    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }



    public Integer getLkmId() {
        return lkmId;
    }

    public void setLkmId(Integer lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                ", customer=" + customer +
                '}';
    }
}
