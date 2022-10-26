package com.organizeit.homeorganizer.Group.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupResponse {
    private UUID id;
    private String name;
}
