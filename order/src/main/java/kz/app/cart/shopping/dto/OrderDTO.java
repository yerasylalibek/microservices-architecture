package kz.app.cart.shopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import kz.app.cart.shopping.model.Customer;
import kz.app.cart.shopping.model.OrderDetail;
import kz.app.cart.shopping.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    @JsonProperty("id")
    @ApiModelProperty(required = true, example = "1", name = "Order id")
    private Long id;

    @JsonProperty("reference_no")
    @ApiModelProperty(example = "1", name = "reference_no")
    private int reference_no;

    @JsonProperty("customerId")
    @ApiModelProperty(example = "1", name = "customer_id")
    private Long customerId;

    @JsonProperty("orderDate")
    @ApiModelProperty(example = "12-12-2020", name = "Order date")
    private Date orderDate;

    @JsonProperty("expectedDeliveryDate")
    @ApiModelProperty(example = "12-12-2020", name = "Expected delivery date")
    private Date expectedDeliveryDate;

    @JsonProperty("numberOfItems")
    @ApiModelProperty(example = "10", name = "Number of items")
    private int numberOfItems;

    @JsonProperty("totalAmount")
    @ApiModelProperty(example = "10", name = "Total amount")
    private int totalAmount;

    @JsonProperty("orderDetailDTO")
    private OrderDetailDTO orderDetailDTO;
}
