package com.transfer;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OrderGetDto {
    private UUID orderId;
    private UUID userId;
    private String userName;
}
