package com.ps.Magazin.validators;

import com.ps.Magazin.model.RolUser;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = RoleTypeSubsetValidator.class)
public @interface RoleTypeSubset {
    RolUser[] anyOf();
    String message() default "must be any of {anyOf}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
