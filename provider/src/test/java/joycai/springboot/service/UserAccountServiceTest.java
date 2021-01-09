package joycai.springboot.service;

import joycai.springboot.dto.UserDto;
import joycai.springboot.model.UserEntity;
import joycai.springboot.repository.UserRepo;
import joycai.springboot.service.impl.UserAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

class UserAccountServiceTest {

    UserRepo userRepo;

    UserAccountService userAccountService;

    @BeforeEach
    void init() {
        userRepo = Mockito.mock(UserRepo.class);
        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setPassword("12345");
        admin.setEnabled(true);
        admin.setId(1L);
        UserEntity user1 = new UserEntity();
        user1.setUsername("user1");
        user1.setPassword("12345");
        user1.setEnabled(false);
        user1.setId(2L);
        Mockito.when(userRepo.findByName("admin")).thenReturn(Optional.of(admin));
        Mockito.when(userRepo.findByName("user1")).thenReturn(Optional.of(user1));
        Mockito.when(userRepo.count()).thenReturn(10L);
        userAccountService = new UserAccountServiceImpl(userRepo);
    }

    @Test
    void apiTest() {
        Assertions.assertTrue(userAccountService.login(new UserDto("admin", "12345", false)));
        Assertions.assertFalse(userAccountService.login(new UserDto("user1", "12345", false)));
        Assertions.assertFalse(userAccountService.login(new UserDto("user2", "12345", false)));
        Assertions.assertEquals(10L, userAccountService.countUser());
    }
}
