package com.zsc.externalservice.entity.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesSummary {
    private String order_weekday;       // 假设该字段是字符串类型
    private Integer sum_qty;             // 假设数量字段是整型
    private Integer sum_branch_qty;      // 假设分支数量字段是整型
    private Double sum_nowithtaxamt;    // 假设无税金额字段是双精度浮点型
    private Double notaxprice;           // 假设无税价格字段是双精度浮点型
}
