package com.attractor.month9onlineshop.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasketAddDTO {
    @NotEmpty
    private String clothesId;
    @NotEmpty
    private String quantity;

}
