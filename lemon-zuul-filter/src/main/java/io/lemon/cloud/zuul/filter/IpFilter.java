package io.lemon.cloud.zuul.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.lemon.cloud.common.response.ResponseData;
import io.lemon.cloud.common.response.ResponseEnum;
import io.lemon.cloud.zuul.utils.IpUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.List;

public class IpFilter extends ZuulFilter {

    private List<String> forbidIpList = Collections.singletonList("127.0.0.1");

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String ip = IpUtil.getIpFromRequest(context.getRequest());
        if (StringUtils.isNotBlank(ip) && forbidIpList.contains(ip)) {
            context.setSendZuulResponse(false);
            ResponseData responseData = ResponseData.fail(ResponseEnum.SC_FORBIDDEN_IP);
            try {
                context.setResponseBody(objectMapper.writeValueAsString(responseData));
            } catch (JsonProcessingException e) {
                throw new ZuulException(e, ResponseEnum.SC_FORBIDDEN_IP.getCode(), "convert object as string");
            }
            context.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        return null;
    }
}
