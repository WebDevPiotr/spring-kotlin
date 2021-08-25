package com.example.light.base

import com.example.light.security.token.JwtTokenFactory
import com.example.light.user.MockUser
import com.example.light.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.containers.PostgreSQLContainer
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*
import javax.servlet.Filter

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@Tag("integration")
class IntegrationTest {

    @Autowired
    private lateinit var context: WebApplicationContext

    @Autowired
    private lateinit var springSecurityFilterChain: Filter

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var jwtTokenFactory: JwtTokenFactory

    @Autowired
    protected lateinit var objectMapper: ObjectMapper

    protected lateinit var token: String
    protected val mockMvc: MockMvc by lazy {
        println("SEIAMMMMM")
        MockMvcBuilders
            .webAppContextSetup(context)
            .addFilters<DefaultMockMvcBuilder>(springSecurityFilterChain)
            .build()
    }

    companion object {

        val postgreSQLContainer = PostgreSQLContainer<Nothing>("postgres:latest").apply {
            withReuse(true)
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", postgreSQLContainer::getUsername)
            registry.add("spring.datasource.password", postgreSQLContainer::getPassword)
        }
    }

    @BeforeAll
    fun setup() {
        val user = userRepository.save(MockUser.getMockedUser())
        token = jwtTokenFactory.createToken(user.email)
    }

}