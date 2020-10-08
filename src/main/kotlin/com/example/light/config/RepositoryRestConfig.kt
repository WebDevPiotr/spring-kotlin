package com.example.light.config

import com.example.light.powerSupply.PowerSupply
import com.example.light.shutter.Shutter
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component

@Component
class RepositoryRestConfig : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.corsRegistry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("Accept", "Content-Type", "Authorization")
                .exposedHeaders("Access-Control-Allow-Origin")

        config.exposeIdsFor(
                PowerSupply::class.java,
                Shutter::class.java
        )
    }
}