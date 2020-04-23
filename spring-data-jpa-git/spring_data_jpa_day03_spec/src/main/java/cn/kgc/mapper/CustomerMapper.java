package cn.kgc.mapper;

import cn.kgc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: spring_data_jpa->CustomerMapper
 * @description:Customer mapper接口
 * JpaRepository<>:操作的实体类型,实体类中主键属性的类型
 *  封装了基本的CRUD
 * JpaSpecificationExecutor<>:
 *  封装了复杂查询
 *
 * 符合spring data jpa规范的接口
 * @author: 兵哥
 * @create: 2020-02-26 11:26
 **/
public interface CustomerMapper extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

}
