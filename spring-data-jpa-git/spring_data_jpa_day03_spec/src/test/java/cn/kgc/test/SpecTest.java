package cn.kgc.test;

import cn.kgc.entity.Customer;
import cn.kgc.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @program: spring_data_jpa->CustomerMapperTest
 * @description: JpaSpecificationd对象测试类
 **/

@RunWith(SpringJUnit4ClassRunner.class) //声明使用spring提供的单元测试
@ContextConfiguration(locations = "classpath:applicationContext.xml")   //指定spring容器的配置信息
public class SpecTest {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 根据用户匹配查询
     */
    @Test
    public void testSpec01() {
        //根据条件查询一个对象
        //匿名内部类
        /**
         * 自定义查询条件
         *  1.实现Specification接口(提供泛型,查询对象类型)
         *  2.实现toPredicate方法(构造查询条件)
         *  3.借助方法中的两个参数
         *      root:获取需要查询的对象属性
         *      CriteriaBuilder:构造查询条件,内部封装了很多查询条件(模糊匹配,精准匹配)
         *  案例:根据客户名称查询
         *          查询条件:
         *                  1.查询方式
         *                  2.比较的属性名称:root对象
         */
        
        Specification<Customer> spec= new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.根据root方法获取需要进行匹配的属性名
                Path<Object> custName = root.get("custName");
                /**
                 * 第一个参数:类中的属性
                 * 第二个参数:具体用来筛选匹配的值
                 */
                Predicate predicate = criteriaBuilder.equal(custName, "北大清华");
                return predicate;
            };
        };
        Customer customer = customerMapper.findOne(spec);
        System.out.println("customer = " + customer);
    }

    /**
     * 根据用户名和用户所属行业查询(精准匹配)
     */
    @Test
    public void testSpec02(){
        Specification<Customer> spec=new Specification<Customer>(){

            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取需要匹配的属性名
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");
                //构造查询
                Predicate p1 = criteriaBuilder.equal(custName, "北大清华");
                Predicate p2 = criteriaBuilder.equal(custIndustry, "教育");
                //条件拼接
                //and方法:与关系  or 或关系
                Predicate predicate = criteriaBuilder.and(p1, p2);
                return predicate;
            }

        };
        Customer customer = customerMapper.findOne(spec);
        System.out.println("customer = " + customer);

    }

    /**
     * 案例:完成根据客户名称模糊匹配,返回客户列表
     * equal:直接到path对象(属性),然后进行比较即可
     * gt,lt,le,like:得到path对象,根据path对象指定比较的的参数类型,再去进行比较
     * 指定参数类型:path.as(类型的字节码对象)
     */
    @Test
   public void testSpec03(){
       Specification<Customer> spec=new Specification<Customer>(){
          public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
              //获取需要匹配的属性名
              Path<Object> custName = root.get("custName");
              //构造查询条件
              Predicate predicate = criteriaBuilder.like(custName.as(String.class), "%北大%");

              return predicate;
          }
      };    /**
         * 排序查询
         * 1.创建一个sort对象
         * 1.1第一个参数,排序规则
         * 1.2第二个参数,排序的属性
         */
       Sort sort = new Sort(Sort.Direction.DESC, "custId");
       List<Customer> list = customerMapper.findAll(spec);
       for(Customer customer:list){
           System.out.println("customer.getCustName() = " + customer.getCustName());
       }
   }

    /**
     * 分页查询
     * Specification:查询条件
     * Pageable:分页参数
     * findAll(Specification,Pageable):带有条件的分页
     * findAll(Pageable):没有有条件的分页
     * 返回:Page(spring data jpa为我们封装好的pageBean对象,数据列表)
     */
    @Test
    public void testSpec04() {
        //PageRequest对象是实现类
        /**
         * 创建PageRequest过程中需要调用构造方法,需要传入两个参数
         *      第一个参数:当前查询的页数(从0开始)
         *      第二个参数:每页大小
         */
        Pageable pageable = new PageRequest(0, 2);
        Page<Customer> page = customerMapper.findAll(pageable);
          System.out.println(page.getTotalPages());//总页数
          System.out.println(page.getContent());//数据列表
          System.out.println(page.getTotalElements());//总条数
    }

}
