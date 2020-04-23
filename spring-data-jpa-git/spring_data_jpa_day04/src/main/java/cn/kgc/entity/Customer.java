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
     * 配置用户到角色的多对多关系
     *  1.声明表关系
     *      @ManyToMany:配置多对多
     *          targetEntity:对方实体类字节码
     *  2.配置中间表(包含两个外键)
     *      @JoinTable:
     *          name:中间表的名称
     *          joinColumns:配置当前对象在中间表的外键
     *          inverseJoinColumns:对方对象在中间表的外键
     */


    @ManyToMany(targetEntity =Linkman.class, cascade = CascadeType.ALL)
    @JoinTable(name = "tb_cust_link",
            //joinColumns:当前对象在中间表的外键
            joinColumns = {@JoinColumn(name ="tb_cust_id", referencedColumnName = "cust_id")},
            //inverseJoinColumns:对方对象在中间中间表中的外键
            inverseJoinColumns ={@JoinColumn(name="tb_link_cust",referencedColumnName = "lkm_id")})

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
