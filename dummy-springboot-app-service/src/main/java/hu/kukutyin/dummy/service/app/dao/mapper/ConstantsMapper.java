package hu.kukutyin.dummy.service.app.dao.mapper;

import org.springframework.stereotype.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;

@Repository
@Mapper
public interface ConstantsMapper extends MyBatisMapper {
    ConstantsDto getRow(@Param("groupId") String groupId, @Param("groupIdKey") String groupIdKey);
}
