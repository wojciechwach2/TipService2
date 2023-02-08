package com.example.TipService.dao;

import com.example.TipService.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void testCreateUser() {
//        UserEntity user = new UserEntity();
//        user.setEmail("kubaRozpruwacz2@gmail.com");
//        user.setPassword("Ragnarok2");
//
//
//        UserEntity savedUser = repo.save(user);
//
//        UserEntity existUser = entityManager.find(UserEntity.class, savedUser.getId());
//
//        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

//    }
}