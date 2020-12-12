package joycai.springboot.service.impl;

import joycai.springboot.dto.UserDto;
import joycai.springboot.model.UserEntity;
import joycai.springboot.repository.UserRepo;
import joycai.springboot.service.UserAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@DubboService(interfaceClass = UserAccountService.class,version = "1.0")
@Component
public class UserAccountServiceImpl implements UserAccountService {

    UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Boolean login(UserDto userDto) {
        Optional<UserEntity> user = userRepo.findByName(userDto.getUsername());
        if (user.isPresent()) {
            return user.get().getEnabled() && user.get().getPassword().equals(userDto.getPassword());
        }else {
            return false;
        }
    }

    @Override
    public Long countUser() {
        return 123l;
    }
}
