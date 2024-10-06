package com.example.POD_BookingSystem.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

//public class NameValidator implements ConstraintValidator<NameConstraint, String> {
//
//        private String name;
//
//        @Override
//        public void initialize(NameConstraint constraintAnnotation) {
//            ConstraintValidator.super.initialize(constraintAnnotation);
//            name = constraintAnnotation.name();
//        }
//
////        @Override
////        public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
////            if(Objects.isNull(string)){
////                return true;
////            }
////
////            long year = ChronoUnit.YEARS.between(localDate, LocalDate.now());
////
////            return year >= min;
////        }
//    }
//}
