package kz.app.cart.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    @JsonProperty("id")
    @ApiModelProperty(example = "1", name = "Id")
    private Long id;

    @JsonProperty("customerCode")
    @ApiModelProperty(example = "1", name = "Code")
    private String customerCode;

    @JsonProperty("avatar")
    @ApiModelProperty(example = "Assel", name = "Name")
    private byte[] avatar;

    @JsonProperty("emailAddress")
    @ApiModelProperty(required = true, example = "aselek.m.s@gmail.com", name = "Email")
    private String emailAddress;

    @JsonProperty("username")
    @ApiModelProperty(required = true, example = "AsselSultan", name = "Username")
    private String username;

    @JsonProperty("password")
    @ApiModelProperty(required = true, example = "hello", name = "Password")
    private String password;

}
