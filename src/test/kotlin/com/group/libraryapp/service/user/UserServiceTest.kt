package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor(
    private val userRepository: UserRepository,
    private val userService: UserService,
) {

    @AfterEach
    fun clean() {
        userRepository.deleteAll()
    }

    //저장 테스트
    @Test
    @DisplayName("유저 저장이 정상적으로 동작한다")
    fun saveUserTest() {
        //given
        val request = UserCreateRequest("홍재현", null);

        //when
        userService.saveUser(request)

        //then
        val results = userRepository.findAll()

        //size가 1인지
        assertThat(results).hasSize(1)

        //이름, 나이 체크
        assertThat(results[0].name).isEqualTo("홍재현")
        assertThat(results[0].age).isNull()
    }

    @Test
    @DisplayName("유저 조회가 정상적으로 동작한다")
    fun getUsersTest() {
        // given
        userRepository.saveAll(
            listOf(
                User("A", 20),
                User("B", null),
            )
        )

        // when
        val results = userService.getUsers()

        // then
        assertThat(results).hasSize(2)
        assertThat(results).extracting("name").containsExactlyInAnyOrder("A", "B")
        assertThat(results).extracting("age").containsExactlyInAnyOrder(20, null)
    }

    @Test
    @DisplayName("유저 수정이 정상적으로 동작한다")
    fun updateUserNameTest() {
        //given
        val savedUser = userRepository.save(User("A", null));

        val request = UserUpdateRequest(savedUser.id!!, "B")

        //when
        userService.updateUserName(request)

        //then
        val result = userRepository.findAll()[0]
        assertThat(result.name).isEqualTo("B")
    }

    @Test
    @DisplayName("유저 삭제가 정상적으로 동작한다")
    fun deleteUserTest() {
        //given
        val savedUser = userRepository.save(User("A", 20));

        //when
        userService.deleteUser(savedUser.name);

        //then
        val result = userRepository.findAll()
        assertThat(result).isEmpty()

    }
}