package com.example.texnoeraspringproject.annotations;


import lombok.Builder;
import lombok.Getter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
//@Getter
//@Builder
@Target(ElementType.FIELD)
public @interface Dto {

}
