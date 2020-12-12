package joycai.springboot.dto

import java.io.Serializable

data class UserDto(
    val username: String,
    val password: String,
    val enabled: Boolean
):Serializable

