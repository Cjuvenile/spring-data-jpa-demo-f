package cn.kgc.jpa.test;

import cn.kgc.entity.Customer;
import cn.kgc.jpa.utils.JpaUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;


/**
 * @program: spring_data_jpa->JpaTest
 * @description: jpa测试类
 **/
public class JpaTest {
    //1.加载配置文件创建工厂（实体类管理工厂）
    private  EntityManagerFactory entityManagerFactory;
    //2.通过实体类管理工获取实体类管理器
    private EntityManager entityManager;
    //3.获取事务对象,开启事务
    private EntityTransaction transaction;

@Before
    public void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("my-jpa");
        entityManager=entityManagerFactory.createEntityManager();
        transaction=entityManager.getTransaction();
        //开启事务
        transaction.begin();
    }
@After
    public void destory(){
    // 5.提交事务
    transaction.commit();

    //  6.释放资源
    entityManager.close();
}


    /**
     * 测试jpa的保存
     * 步骤:
     *  1.加载配置文件创建工厂(实体类管理工厂)
     *  2.通过实体类管理工获取实体类管理器
     *  3.获取事务对象,开启事务
     *  4.完成CURUD操作
     *  5.提交事务
     *  6.释放资源
     */

    @Test
    public void testSave(){
//        //1.加载配置文件创建工厂（实体类管理工厂）
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-jpa");
//        //2.通过实体类管理工获取实体类管理器
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        //3.获取事务对象,开启事务
//        EntityTransaction transaction=entityManager.getTransaction();
//        //开启事务
//        transaction.begin();

        //4.进行保存操作
        Customer customer = new Customer();
        customer.setCustName("华大职业教育");
        customer.setCustIndustry("教育");
        customer.setCustSource("大众需求");
        customer.setCustLevel("vip");
        customer.setCustAddress("厦门软件园");
        customer.setCustPhone("110");

        entityManager.persist(customer);

//        // 5.提交事务
//        transaction.commit();
//
//        //  6.释放资源
//        entityManager.close();

    }
    @Test
    public void testRemove() {
        //先查询,再进行删除
        Customer customer = entityManager.getReference(Customer.class, 1);
        //调用删除方法
        entityManager.remove(customer);
    }
@Test
    public void testFindAll(){
        String jpql="from Customer";
        Query query=entityManager.createQuery(jpql);
        List list =query.getResultList();
        for(Object obj : list){
            System.out.println(obj);
        }
    }
@Test
    public void testPage(){
    String jpql="from Customer";
    Query query=entityManager.createQuery(jpql);
    //进行条件拼接
    //1.拼接起始页
    query.setFirstResult(0);
    //1.每页大小
    query.setMaxResults(2);
    //封装成list
    List list =query.getResultList();
    for(Object obj : list){
        System.out.println(obj);
    }
}
    /**
     * 降序查询
     * sql:SELECT *  FROM tb_cust ORDER BY cust_id DESC
     * jpql:from Customer ORDER BY custId DESC
     */
    @Test
    public void testOrder() {
//        EntityManager entityManager = JpaUtil.getEntityManager();
//        //事务
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();

        //通过jpaql进行查询
        String jpql = "from Customer order by custId desc ";
        Query query = entityManager.createQuery(jpql);

        //封装成list
        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }
    }
    /**
     * 条件查询
     * sql:SELECT *  FROM tb_cust WHERE cust_name like '%华%'
     * jpql:from Customer WHERE custName like '%华%'
     */
    @Test
    public void testWhere(){
        String jpql="from Customer  WHERE custName like ?";
        Query query = entityManager.createQuery(jpql);
        /**
         * 对占位符进行赋值
         * 第一个参数:占位符的索引位置,从 1开始
         * 第二个参数:具体值
         */
        query.setParameter(1, "%华大%");

        //封装成list
        List resultList = query.getResultList();

        for (Object obj : resultList) {
            System.out.println(obj);
        }

    }


    /**
     * 统计查询
     * sql:SELECT COUNT(cust_id)  FROM tb_cust
     * jpql:select count(custId) from Customer
     */
    @Test
    public void testCount() {
        //通过jpqj进行查询
        String jpql = "select count(custId) from Customer";
        Query query = entityManager.createQuery(jpql);

        //对查询出来的参数进行处理
        Object result = query.getSingleResult();
        System.out.println("result = " + result);
    }
}
