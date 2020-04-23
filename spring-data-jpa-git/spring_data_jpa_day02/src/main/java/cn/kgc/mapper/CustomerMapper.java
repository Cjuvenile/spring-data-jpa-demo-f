package cn.kgc.mapper;

import cn.kgc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: JPA_study->CustomerMapper
 * @description: jpql查询
 * 1.简单查询不用具体写sql只需要继承空间就可以  hql
 * 2.复杂查询才需要具体的在这里写jpql
 * 3.sql : nativeQuery = true
 * 4.方法命名规则查询 连jpql都省略
 *  方法必须以findBy开头
 *      格式 findBy + 属性名(类中属性名,首字母大写)
 **/

public interface CustomerMapper extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {


    /**
     * 通过jpql完成查询列表
     * jpql:from Customer
     */
    @Query(value = "from Customer")
    List<Customer> getCustomerList();

    /**
     * 多条件查询
     *  jpql:from Customer where custName like ? and custId = ?
     *  sql:select * from tb_customer where cust_name like ? and cust_id = ?
     */

    @Query(value = "select * from tb_customer where cust_name like ? and cust_id = ?", nativeQuery = true)
    Customer getOne(String name, Integer id );

//    @Query(value = "from Customer where custName like ? and custId = ?") 两种都可以 默认 nativeQuery = false 不使用sql 而是jpql 类字段
    @Query(value = "from Customer where custName like ?1 and custId = ?2")
    Customer getOne2(String name, Integer id );


    /**
     * 通过jpql完成修改
     * jpql:update Customer set custName = ? where custId = ?
     */
    @Query(value = "update Customer set custName = ?1 where custId = ?2")
    @Modifying
    void updateCustomer(String name, Integer id);

    /**
     * 方法命名规则查询
     *  方法必须以findBy开头
     *      格式 findBy + 属性名(类中属性名,首字母大写)
     */
    Customer findByCustName(String name);

    /**
     * 放大命名规则查询
     *  根据客户名模糊查询及主键
     *      格式:
     *          findBy + 属性名 + 查询关键字(首字母大写) + 查询关键字 + 属性名
     */
    //from Customer where custName like ? and custId = ?
    Customer findByCustNameLikeAndCustId(String name, Integer id);
}

