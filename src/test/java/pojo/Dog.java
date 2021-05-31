package pojo;

import lombok.*;

@Getter @Setter
@ToString
public class Dog{
    private String breed ;
    private String color ;
    private int age;
    private Owner owner ;
}
