package com.pichincha.dm.cura.customer.domain.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Service;

/**
 * Custom annotation to mark domain use case implementations as Spring services.
 * This ensures that the domain layer remains technology-agnostic while still allowing
 * Spring to detect and manage these components as beans.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface UseCaseService {
}
