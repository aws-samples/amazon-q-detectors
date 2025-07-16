// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-csrf-protection@v1.0 defects=1}
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        // Noncompliant: Disabling CSRF protection makes the application vulnerable to cross-site request forgery attacks.
        http.csrf().disable()
        
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
        
        return http.build()
    }
}
// {/fact}
