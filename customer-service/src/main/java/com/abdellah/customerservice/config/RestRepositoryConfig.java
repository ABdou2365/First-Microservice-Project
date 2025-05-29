package com.abdellah.customerservice.config;

import com.abdellah.customerservice.entities.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Configuration personnalisée pour Spring Data REST.
 *
 * Cette classe permet de configurer le comportement des endpoints REST générés
 * automatiquement par Spring Data REST. Elle est utilisée ici pour exposer les
 * identifiants (ID) des entités dans les réponses JSON.
 */
@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {

    /**
     * Méthode de configuration des endpoints REST.
     *
     * @param config l'objet de configuration REST.
     * @param cors   l'objet de configuration CORS (Cross-Origin Resource Sharing),
     *               qui peut être utilisé pour autoriser les requêtes cross-domain.
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Expose les identifiants de l'entité Customer dans les réponses JSON.
        config.exposeIdsFor(Customer.class);
    }
}