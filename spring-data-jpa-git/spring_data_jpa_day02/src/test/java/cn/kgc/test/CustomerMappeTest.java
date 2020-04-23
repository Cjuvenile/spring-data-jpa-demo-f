package cn.kgc.test;



import cn.kgc.entity.Customer;
import cn.kgc.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//标注使用spring单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")//读取ioc容器
public class CustomerMappeTest {


    @Autowired
    private CustomerMapper customerMapper;
    /**
     * save()方法:
     *      1.如果提供了id就视为更新,视为保存
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("北大青鸟");
        customer.setCustAddress("厦门软件园");
        customer.setCustLevel("svip");
        customer.setCustSource("网络");
        customer.setCustIndustry("教育");

        //执行保存
        customerMapper.save(customer);
    }
    /**
     * 测试更新
     */
    @Test
    public void testUapdate(){
        Customer customer = new Customer();
        customer.setCustName("你的太阳");
        customer.setCustId(3);

        //执行保存 save也可以执行修改，只要有指明存在的id
        customerMapper.save(customer);

    }

    /**
     * 测试根据id查询
     */
    @Test
        public void testFindOne(){
            Customer customer = customerMapper.findOne(1);
            System.out.println("customer = " + customer);
        }
    /**
     * 测试删除
     */
        @Test
        public void testDelete(){
        customerMapper.delete(1);
        }
}
