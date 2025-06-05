package org.hyeonqz.jpabestexample.config;

import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProxyDataSourceInterceptor {
    private final DataSource dataSource;

    public ProxyDataSourceInterceptor(DataSource dataSource) {
        super();

        this.dataSource = ProxyDataSourceBuilder.create().dataSource(dataSource)
                .name("DATA_SOURCE_PROXY")
                .logQueryBySlf4j(SLF4JLogLevel.INFO)
                .multiline()
                .countQuery()
                .build();
    }
}
