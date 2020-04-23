package cn.kgc.entity;


import javax.persistence.*;

/**
 * @program: JPA_study->Customer
 * @description: �ͻ�ʵ��
 * 1.��ʵ�������ݿ�����ӳ��
 *    @Entity
 *    @Table
 * 2.ʵ�����е����Ժͱ����ֶ�ӳ��
 **/

@Entity
@Table(name = "tb_customer")
public class Customer {

    //����
    @Id
    @Column(name = "cust_id")
    //column����������ƺͱ����ֶ�һ�¿���ʡ��
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;

    //�ͻ�����
    @Column(name = "cust_name")
    private String custName;

    //�ͻ���Դ
    @Column(name = "cust_source")
    private String custSource;

    //������ҵ
    @Column(name = "cust_industry")
    private String custIndustry;

    //�ͻ��ȼ�
    @Column(name = "cust_level")
    private String custLevel;

    //�ͻ���ַ
    @Column(name = "cust_address")
    private String custAddress;

    //�ͻ��绰
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
