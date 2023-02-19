package hu.kukutyin.own.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import hu.kukutyin.own.app.entity.ConstantsEntity;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OwnAppWithTestingApplicationJPATests {
    private static final Long CONSTANTS_ENTITY_ID_1 = 1L;

    @Autowired
    private TestEntityManager entityManager;

    private ConstantsEntity constants1;

    @BeforeEach
    public void setUp() {
        constants1 = new ConstantsEntity();
        constants1.setGroupId("callback");
        constants1.setConstKey("verify_token");
        constants1.setConstValue("09f21538-cedf-4bde-aa72-effe3ea2e72c");
        constants1.setDescription("Ezzel azonositjuk a hozzánk érkező kéréseket.");
    }

    @Test
    public void constantsEntitiesTest() {
        ConstantsEntity savedConstantsEntity1 = this.entityManager.persistFlushFind(constants1);
        assertThat(savedConstantsEntity1.getId()).isNotNull();
        assertThat(savedConstantsEntity1.getId()).isEqualTo(CONSTANTS_ENTITY_ID_1);
        assertThat(savedConstantsEntity1.getGroupId()).isEqualTo("callback");
        assertThat(savedConstantsEntity1.getConstKey()).isEqualTo("verify_token");
        assertThat(savedConstantsEntity1.getConstValue()).isEqualTo("09f21538-cedf-4bde-aa72-effe3ea2e72c");
    }
}
