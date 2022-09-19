package com.example.texnoeraspringproject.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
@ApiModel("This is model of book table")
public class BookDto {
    @ApiModelProperty("this is id of book")
    private Long id;

    @NotBlank(message = "name of book can not be empty")
    @ApiModelProperty("this is name of book")
    private String name;

    @NotNull(message = "book can not be free")
    @ApiModelProperty("this is price of book")
    private BigDecimal price;

    @ApiModelProperty("created time of book")
    private LocalDateTime createdAt;


}
