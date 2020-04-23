package cn.kgc.entity;

import javax.persistence.*;

/**
 * @program: spring_data_jpa->Customer
 * @description: 客户实体
 * 通过注解方式进行实体类和数据表进行映射
 *  1.@Entity：标识当前类是一个实体类,与数据库的对应
 *  2.@Table():与之对应的表名
 * @author: 兵哥
 * @create: 2020-02-25 09:05
 **/

@Entity
@Table(name = "tb_cust")
public class Customer {

    //主键
    @Id //标识此属性为主键
    @Column(name = "cust_id")   //标识表中字段名
    /**
     * @GeneratedValue :主键生成策略
     *      TABLE, 选择jpa规范的主键
     *     SEQUENCE, 根据序列生成主键
     *     IDENTITY,  根据自增生成主键
     *     AUTO; 自动选择
     *、、
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;

    //客户名称
    @Column(name = "cust_name")
    private String custName;

    //客户来源
    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_industry")
    private String custIndustry;

    //客户等级
    @Column(name = "cust_level")
    private String custLevel;

    //客户地址
    @Column(name = "cust_adddress")
    private String custAddress;

    //客户电话
    @Column(name = "cust_phone")
    private String custPhone;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
