package joycai.springboot.controller;

import com.google.common.collect.Maps;
import joycai.springboot.dto.UserDto;
import joycai.springboot.service.UserAccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @DubboReference(interfaceClass = UserAccountService.class, version = "1.0")
    UserAccountService userAccountService;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody UserDto userDto) {
        Boolean success = userAccountService.login(userDto);
        Map<String, Object> ret = Maps.newHashMap();
        ret.put("success", success);
        return ret;
    }
}
