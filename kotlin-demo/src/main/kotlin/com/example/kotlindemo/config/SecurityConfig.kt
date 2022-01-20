package com.example.kotlindemo.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.lang.Exception

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig: WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
        http.authorizeRequests(Customizer { s ->
            s.mvcMatchers("/health") ///health エンドポイントのみ保護を除外す
                .permitAll()
                .anyRequest()
                .authenticated()
        })
            .oauth2ResourceServer()
            .opaqueToken() // TßokenIntrospection を利用する場合は opaqueToken() を指定
        http.cors().configurationSource(this.corsConfigurationSource()) //cors設定(現状デフォルト)
    }

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod("*")
        corsConfiguration.addAllowedOrigin("http://localhost:3000")
        corsConfiguration.addAllowedHeader("*")
        val corsSource = UrlBasedCorsConfigurationSource()
        corsSource.registerCorsConfiguration("/**", corsConfiguration);

        return corsSource
    }

}
