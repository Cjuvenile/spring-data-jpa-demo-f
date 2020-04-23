package cn.kgc.mapper;

import cn.kgc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: spring_data_jpa->CustomerMapper
 * @description: 客户dao接口
 **/
public interface CustomerMapper extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
}
