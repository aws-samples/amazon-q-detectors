// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-csrf-protection@v1.0 defects=1}
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.invoke

// Noncompliant: CSRF protection disabled
@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
        }
        return http.build()
    }
}
// {/fact}
