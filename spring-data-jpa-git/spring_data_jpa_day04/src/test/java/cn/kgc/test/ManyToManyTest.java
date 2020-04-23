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
public class ManyToManyTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private LinkManMapper linkManMapper;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("客户1");

        Linkman linkman = new Linkman();
        linkman.setLkmName("联系人1");

        //映射关联关系
        linkman.getCustomer().add(customer);
        customer.getLinkmens().add(linkman);

        customerMapper.save(customer);
        linkManMapper.save(linkman);
    }
    /**
     * 测试级联添加:保存一个用户的同时保存用户的关联角色
     * 打开级联 cascade = CascadeType.ALL
     *
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd2() {
        Customer customer = new Customer();
        customer.setCustName("客户1");

        Linkman linkman = new Linkman();
        linkman.setLkmName("联系人1");

        //映射关联关系
        linkman.getCustomer().add(customer);//配置用户到角色的关系
        customer.getLinkmens().add(linkman);

        customerMapper.save(customer);

    }

    /**
     * 测试级联删除:删除一个用户的同时删除用户的关联角色
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
