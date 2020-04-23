package cn.kgc.mapper;

import cn.kgc.entity.Linkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @program: spring_data_jpa->LinkManMapper
 * @description: 联系人dao接口
 **/
public interface LinkManMapper extends JpaRepository<Linkman, Integer>, JpaSpecificationExecutor<Linkman> {
}
