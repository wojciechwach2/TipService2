package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class CategoryDto {
    // klasę z odpowiednimi polami i setterami/getterami. Klasa ta powinna zawierać tylko te pola, które są potrzebne
    // dla danej warstwy aplikacji. Następnie należy użyć tej klasy w kontrolerze lub serwisie, aby przesyłać dane między warstwami.

    private Long categoryId;
    private String categoryName;



}
