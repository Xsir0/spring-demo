package com.example.demo.formatter;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.math.BigDecimal;

@Data
@Builder
public class FormatterBean {


    @Tolerate
    public FormatterBean() {
    }

    @NumberFormat(style = NumberFormat.Style.CURRENCY,pattern = "###,###.###")
    private BigDecimal currency;

    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private BigDecimal percent;


    public static void main(String[] args) {
        FormatterBean build = FormatterBean.builder().currency(BigDecimal.valueOf(1000000.2)).percent(BigDecimal.valueOf(10.1)).build();

        System.out.println(build.getCurrency());

    }


}
