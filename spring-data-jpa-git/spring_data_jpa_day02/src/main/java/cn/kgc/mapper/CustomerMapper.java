package cn.kgc.mapper;

import cn.kgc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @program: JPA_study->CustomerMapper
 * @description: jpql???
 * 1.???????????дsql??????п??????  hql
 * 2.??????????????????????дjpql
 * 3.sql : nativeQuery = true
 * 4.?????????????? ??jpql?????
 *  ??????????findBy???
 *      ??? findBy + ??????(??????????,???????д)
 **/

public interface CustomerMapper extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {


    /**
     * ???jpql??????б?
     * jpql:from Customer
     */
    @Query(value = "from Customer")
    List<Customer> getCustomerList();

    /**
     * ?????????
     *  jpql:from Customer where custName like ? and custId = ?
     *  sql:select * from tb_customer where cust_name like ? and cust_id = ?
     */

    @Query(value = "select * from tb_customer where cust_name like ? and cust_id = ?", nativeQuery = true)
    Customer getOne(String name, Integer id );

//    @Query(value = "from Customer where custName like ? and custId = ?") ????????? ??? nativeQuery = false ?????sql ????jpql ?????
    @Query(value = "from Customer where custName like ?1 and custId = ?2")
    Customer getOne2(String name, Integer id );


    /**
     * ???jpql??????
     * jpql:update Customer set custName = ? where custId = ?
     */
    @Query(value = "update Customer set custName = ?1 where custId = ?2")
    @Modifying
    void updateCustomer(String name, Integer id);

    /**
     * ??????????????
     *  ??????????findBy???
     *      ??? findBy + ??????(??????????,???????д)
     */
    Customer findByCustName(String name);

    /**
     * ?????????????
     *  ????????????????????
     *      ???:
     *          findBy + ?????? + ????????(???????д) + ???????? + ??????
     */
    //from Customer where custName like ? and custId = ?
    Customer findByCustNameLikeAndCustId(String name, Integer id);
}

