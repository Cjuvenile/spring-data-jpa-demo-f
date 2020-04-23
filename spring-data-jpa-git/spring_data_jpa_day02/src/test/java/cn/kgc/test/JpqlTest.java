 package cn.kgc.test;


import cn.kgc.entity.Customer;
import cn.kgc.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: JPA_study->CustomerMapperTest
 * @description: jpa测试类
 **/

@RunWith(SpringJUnit4ClassRunner.class) //标注使用spring单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")    //读取ioc容器
public class JpqlTest {

    @Autowired
    private CustomerMapper customerMapper;


    /**
     * 测试jpql查询所有
     */
    @Test
    public void testGetCustomerList() {
        List<Customer> customerList = customerMapper.getCustomerList();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }


    /**
     * 测试jpql条件查询
     */
    @Test
    public void testGetOne() {
        Customer customer = customerMapper.getOne("%北大%", 2);
        System.out.println("customer = " + customer);
    }
    @Test
    public void testGetOne2() {
        Customer customer = customerMapper.getOne2("%北大%", 2);
        System.out.println("customer = " + customer);
    }


    /**
     * 测试jpql修改
     */
    @Test
    @Transactional
//    默认打开回滚 要保存修改必须关闭回滚
    @Rollback(value = false)
    public void testUpdateCustomer() {
        customerMapper.updateCustomer("北大清华", 2);
    }


    /**
     * 测试方法命名规则查询
     *  根据客户名称
     */
    @Test
    public void testFindByCustName() {
        Customer customer = customerMapper.findByCustName("北大清华");
        System.out.println("customer = " + customer);
    }

    /**
     * 测试方法命名规则查询
     *  通过客户名模糊查询和id
     */
    @Test
    public void testFingByLikeCustNameAndCustId() {
        Customer customer = customerMapper.findByCustNameLikeAndCustId("%北大%", 2);
        System.out.println("customer = " + customer);
    }


}
