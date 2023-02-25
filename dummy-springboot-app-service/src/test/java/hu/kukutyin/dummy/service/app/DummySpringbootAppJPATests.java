package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import hu.kukutyin.dummy.service.app.entity.ConstantsEntity;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID_1;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@TestPropertySource(locations = "/application/jpa/application-jpa.yaml")
class DummySpringbootAppJPATests {

    @Autowired
    private TestEntityManager entityManager;

    private ConstantsEntity constants1;

    @BeforeEach
    public void setUp() {
        constants1 = new ConstantsEntity();
        constants1.setGroupId(ID_1_GROUP_ID);
        constants1.setGroupIdKey(ID_1_GROUP_ID_KEY);
        constants1.setGroupIdValue(ID_1_GROUP_ID_VALUE);
        constants1.setDescription(ID_1_GROUP_ID_DESCRIPTION);
    }

    @Test
    public void constantsEntitiesTest() {
        ConstantsEntity savedConstantsEntity1 = this.entityManager.persistFlushFind(constants1);
        assertThat(savedConstantsEntity1.getId()).isNotNull();
        assertThat(savedConstantsEntity1.getId()).isEqualTo(ID_1_ENTITY_ID_1);
        assertThat(savedConstantsEntity1.getGroupId()).isEqualTo(ID_1_GROUP_ID);
        assertThat(savedConstantsEntity1.getGroupIdKey()).isEqualTo(ID_1_GROUP_ID_KEY);
        assertThat(savedConstantsEntity1.getGroupIdValue()).isEqualTo(ID_1_GROUP_ID_VALUE);
    }
}
