package joycai.springboot.service.impl;

import joycai.springboot.dto.UserDto;
import joycai.springboot.model.UserEntity;
import joycai.springboot.repository.UserRepo;
import joycai.springboot.service.UserAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@DubboService(interfaceClass = UserAccountService.class, version = "1.0")
@Component
public class UserAccountServiceImpl implements UserAccountService {

    UserRepo userRepo;

    public UserAccountServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Boolean login(UserDto userDto) {
        Optional<UserEntity> user = userRepo.findByName(userDto.getUsername());
        return user.filter(userEntity -> userEntity.getEnabled() && userEntity.getPassword().equals(userDto.getPassword())).isPresent();
    }

    @Override
    public Long countUser() {
        return userRepo.count();
    }
}
