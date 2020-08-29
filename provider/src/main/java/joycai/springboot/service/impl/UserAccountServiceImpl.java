package joycai.springboot.service.impl;

import joycai.springboot.service.UserAccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService(interfaceClass = UserAccountService.class,version = "1.0")
@Component
public class UserAccountServiceImpl implements UserAccountService {


    @Override
    public Long countUser() {
        return 100l;
    }
}
