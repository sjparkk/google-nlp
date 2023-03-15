package com.example.googlenlp.config

import com.google.cloud.language.v1.LanguageServiceClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GoogleConfig {

    @Bean
    fun googleLanguageServiceClient(): LanguageServiceClient {
        return LanguageServiceClient.create()
    }
}