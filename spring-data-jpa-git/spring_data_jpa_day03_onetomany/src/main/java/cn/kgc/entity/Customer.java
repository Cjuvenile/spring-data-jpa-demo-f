package cn.kgc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: spring_data_jpa->Customer
 * @description: 客户实体
 **/

@Entity
@Table(name = "tb_customer")
public class Customer {

    //主键
    @Id //标识此属性为主键
    @Column(name = "cust_id")   //标识表中字段名
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;

    //客户名称
    @Column(name = "cust_name")
    private String custName;

    //客户来源
    @Column(name = "cust_source")
    private String custSource;

    //客户所属行业
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

    /**
     * 配置客户和联系人的一对多关系
     * 使用注解形式配置多表关系
     *  1.声明关系
     *      @OneToMany:配置一对多关系
     *          targetEntity:对方对象的字节码对象
     *  2.配置外建(中间表)
     *      @JoinColumn:配置外键
     *              name:外键字段名称
     *              referencedColumnName:参照的主表的主键字段名称
     *  在客户实体类上(一的一方)添加了外键配置,所以对于客户而言,也具备了维护外键的作用
     */
//    @OneToMany(targetEntity = Linkman.class)
//    @JoinColumn(name = "tb_cust_id", referencedColumnName = "cust_id")
    /**
     * 放弃外键维护权
     *      mappedBy:对方配置关系的属性名称
     *      cascade:设置级联(可以配置到多表的映射关系的注解上)
     *          CascadeType.ALL:        所有
     *                      .MERGE:     更新
     *                      .PERSIST:   保存
     *                      .REMOVE:    删除
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Linkman> linkmens =new HashSet<Linkman>();


    public Set<Linkman> getLinkmens() {
        return linkmens;
    }

    public void setLinkmens(Set<Linkman> linkmens) {
        this.linkmens = linkmens;
    }

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
                ", linkmens=" + linkmens +
                '}';
    }
}
