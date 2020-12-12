package joycai.springboot.service;

import joycai.springboot.dto.UserDto;

public interface UserAccountService {

    Boolean login(UserDto userDto);

    Long countUser();
}
