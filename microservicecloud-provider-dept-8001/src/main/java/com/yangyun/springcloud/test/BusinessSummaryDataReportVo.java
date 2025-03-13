package com.yangyun.springcloud.test;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author yangyun
 * @project saas
 * @description: 经营总表
 * @date 2024-05-14 13:50
 */
@Data
@ToString
public class BusinessSummaryDataReportVo implements Serializable {

    private static final long serialVersionUID = 0L;

    private String a;

    private String b;

    private String c;

    private String d;
}