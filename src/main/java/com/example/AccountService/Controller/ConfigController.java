package com.example.AccountService.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${welcome.message:Hello default}")
    private String message;

    @Value("${spring.datasource.url: }")
    private String dataSourceUrl;

    @GetMapping("/dataSourceUrl")
    String getMessage() {
        return String.format("DataSourceUrl: %s", this.dataSourceUrl);
    }

}
