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

    @JsonProperty("curtomer_id")
    @ApiModelProperty(example = "1", name = "curtomer_id")
    private Long customerId;

    @JsonProperty("order_date")
    @ApiModelProperty(example = "12-12-2020", name = "Order date")
    private Date orderDate;

    @JsonProperty("expected_delivery_date")
    @ApiModelProperty(example = "12-12-2020", name = "Expected delivery date")
    private Date expectedDeliveryDate;

    @JsonProperty("number_of_items")
    @ApiModelProperty(example = "10", name = "Number of items")
    private int numberOfItems;

    @JsonProperty("total_amount")
    @ApiModelProperty(example = "10", name = "Total amount")
    private int totalAmount;}