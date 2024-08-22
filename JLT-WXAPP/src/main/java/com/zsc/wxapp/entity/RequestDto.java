package com.zsc.wxapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zsc.wxapp.entity.dto.PriceTagDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestDto {
    @JsonProperty("res")
    private List<PriceTagDto> res;
}