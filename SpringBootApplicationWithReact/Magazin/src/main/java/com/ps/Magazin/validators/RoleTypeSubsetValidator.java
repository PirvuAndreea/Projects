package com.ps.Magazin.validators;

import com.ps.Magazin.model.RolUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class RoleTypeSubsetValidator implements ConstraintValidator<RoleTypeSubset, RolUser> {
    private RolUser subset[];

    @Override
    public void initialize(RoleTypeSubset constraintAnnotation) {
        this.subset=constraintAnnotation.anyOf();

    }

    @Override
    public boolean isValid(RolUser rolUser, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.asList(subset).contains(rolUser);
    }
}
