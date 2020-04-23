package cn.kgc.test;

import cn.kgc.entity.Customer;
import cn.kgc.entity.Linkman;
import cn.kgc.mapper.CustomerMapper;
import cn.kgc.mapper.LinkManMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * @program: spring_data_jpa->CustomerMapperTest
 * @description: JpaSpecificationd对象测试类
 **/

@RunWith(SpringJUnit4ClassRunner.class) //声明使用spring提供的单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")   //指定spring容器的配置信息
public class OneToManyTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private LinkManMapper linkManMapper;


    /**
     * 测试新增
     * 新增一个客户一个联系人
     * 两条insert,1条updata
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd01() {
        Customer customer = new Customer();
        customer.setCustName("客户1");

        Linkman linkman = new Linkman();
        linkman.setLkmName("联系人1");

        //映射关联关系
        customer.getLinkmens().add(linkman);

        customerMapper.save(customer);
        linkManMapper.save(linkman);
    }


    /**
     * 测试新增（放弃维护）可删表也可以不删表
     * 新增一个客户一个联系人
     * 两条insert
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testAdd02() {
        Customer customer = new Customer();
        customer.setCustName("客户1");

        Linkman linkman = new Linkman();
        linkman.setLkmName("联系人1");

        //映射关联关系
        customer.getLinkmens().add(linkman);

        customerMapper.save(customer);
        linkManMapper.save(linkman);
    }

    /**
     * 级联保存
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("客户1");

        Linkman linkman = new Linkman();
        linkman.setLkmName("联系人1");

        //映射关联关系
        linkman.setCustomer(customer);
        customer.getLinkmens().add(linkman);

        customerMapper.save(customer);
    }


    /***
     * 级联删除
     * 删除客户的同时删除联系人
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeRemove() {
        //查询客户
        Customer one = customerMapper.findOne(2);
        //删除
        customerMapper.delete(one);
    }


}
