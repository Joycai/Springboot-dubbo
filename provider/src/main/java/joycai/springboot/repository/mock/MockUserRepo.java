package joycai.springboot.repository.mock;

import joycai.springboot.model.UserEntity;
import joycai.springboot.repository.UserRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("UserRepo")
public class MockUserRepo implements UserRepo {

    private List<UserEntity> userEntityList;

    private Long idCount = 1L;

    public MockUserRepo() {
        userEntityList = new ArrayList<>();
        UserEntity admin = new UserEntity();
        admin.setEnabled(true);
        admin.setUsername("admin");
        admin.setPassword("12345");
        admin.setId(1L);

        userEntityList.add(admin);
    }

    private synchronized Long getIdAndAdd() {
        return ++idCount;
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        if (userEntity.getId() == null) {
            userEntity.setId(getIdAndAdd());
            userEntityList.add(userEntity);
        } else {
            Optional<UserEntity> entity = userEntityList.stream().filter(it -> it.getId() == userEntity.getId()).findFirst();
            if (entity.isPresent()) {
                UserEntity db = entity.get();
                db.setUsername(userEntity.getUsername());
                db.setEnabled(userEntity.getEnabled());
                db.setPassword(userEntity.getPassword());
            }
        }
        return userEntity;
    }

    @Override
    public Optional<UserEntity> findByName(String username) {
        return userEntityList.stream().filter(it -> it.getUsername().equals(username)).findFirst();
    }

    @Override
    public Boolean existsByName(String username) {
        List<UserEntity> users = userEntityList.stream().filter(userEntity -> userEntity.getUsername().equals(username)).collect(Collectors.toList());
        return !users.isEmpty();
    }

    @Override
    public Long delete(UserEntity userEntity) {
        return deleteByName(userEntity.getUsername());
    }

    @Override
    public Long deleteByName(String username) {
        List<UserEntity> users = userEntityList.stream().filter(userEntity -> userEntity.getUsername().equals(username)).collect(Collectors.toList());
        userEntityList.removeAll(users);
        return (long) users.size();
    }

    @Override
    public Long count() {
        return (long) userEntityList.size();
    }
}
