package joycai.springboot.repository;

import joycai.springboot.model.UserEntity;

import java.util.Optional;

public interface UserRepo {
    UserEntity saveUser(UserEntity userEntity);

    Optional<UserEntity> findByName(String username);

    Boolean existsByName(String username);

    Long delete(UserEntity userEntity);

    Long deleteByName(String username);

    Long count();
}
