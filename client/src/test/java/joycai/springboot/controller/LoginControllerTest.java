package joycai.springboot.controller;

import joycai.springboot.dto.UserDto;
import joycai.springboot.service.UserAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class LoginControllerTest {

    UserAccountService mockUserAccountService;

    LoginController loginController;
    @BeforeEach
    void init() {
        mockUserAccountService = Mockito.mock(UserAccountService.class);
        loginController = new LoginController();
        loginController.userAccountService = mockUserAccountService;
    }
    @Test
    void login() {
        UserDto userDto = new UserDto("test", "123", true);
        Mockito.when(mockUserAccountService.login(any())).thenReturn(Boolean.TRUE);

        Assertions.assertTrue((Boolean) loginController.login(userDto).get("success"));
    }
}