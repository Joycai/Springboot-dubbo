package joycai.springboot.controller;

import joycai.springboot.service.UserAccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @DubboReference(interfaceClass = UserAccountService.class, version = "1.0")
    UserAccountService userAccountService;

    @GetMapping("test")
    public String test() {
        return userAccountService.countUser()+" ";
    }
}
