package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
  private val userRepository: UserRepository,
  private val userService: UserService,
) {

    @Test
    fun saveUserTest() {
        //given

        //when

        //then
    }
}