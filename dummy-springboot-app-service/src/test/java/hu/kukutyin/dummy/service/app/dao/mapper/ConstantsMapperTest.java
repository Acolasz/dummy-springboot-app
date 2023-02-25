package hu.kukutyin.dummy.service.app.dao.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID_1;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
@TestPropertySource(locations = "/application/mybatis/application-mybatis.yaml")
public class ConstantsMapperTest {

    @Autowired
    private ConstantsMapper constantsMapper;

    @Test
    void getRowTest() {
        ConstantsDto constants = constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY);
        assertThat(constants.getId()).isEqualTo(ID_1_ENTITY_ID_1);
        assertThat(constants.getGroupIdValue()).isEqualTo(ID_1_GROUP_ID_VALUE);
    }
}
