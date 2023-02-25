package hu.kukutyin.dummy.service.app.dao.mapper;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @see "https://github.com/mybatis/spring-boot-starter/tree/master/mybatis-spring-boot-samples/mybatis-spring-boot-sample-annotation/src/main/java/sample/mybatis/annotation"
 */
@MybatisTest
@ActiveProfiles("mybatis")
public class ConstantsMapperTest {

    @Autowired
    private ConstantsMapper constantsMapper;

    @Test
    void getRowId1Test() {
        ConstantsDto constants = constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY);
        assertThat(constants.getId()).isEqualTo(ID_1_ENTITY_ID);
        assertThat(constants.getGroupIdValue()).isEqualTo(ID_1_GROUP_ID_VALUE);
    }

    @Test
    void getRowId2Test() {
        ConstantsDto constants = constantsMapper.getRow(ID_2_GROUP_ID, ID_2_GROUP_ID_KEY);
        assertThat(constants.getId()).isEqualTo(ID_2_ENTITY_ID);
        assertThat(constants.getGroupIdValue()).isEqualTo(ID_2_GROUP_ID_VALUE);
    }
}
