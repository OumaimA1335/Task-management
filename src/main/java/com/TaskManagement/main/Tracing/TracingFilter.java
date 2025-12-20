package com.TaskManagement.main.Tracing;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TracingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Trace info from Spring Micrometer (auto-injected)
        String traceId = MDC.get("traceId");  // provided by Micrometer
        String spanId = MDC.get("spanId");

        // Add trace info to MDC for logging
        MDC.put("traceId", traceId);
        MDC.put("spanId", spanId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("traceId");
            MDC.remove("spanId");
        }
    }
}
