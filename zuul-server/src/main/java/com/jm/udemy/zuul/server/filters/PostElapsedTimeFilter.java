package com.jm.udemy.zuul.server.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Component
public class PostElapsedTimeFilter extends ZuulFilter
{
    @Override
    public String filterType()
    {
        //pre, post o route
        return "post";
    }

    @Override
    public int filterOrder()
    {
        //Se define el orden de ejecucion del filtro
        return 1;
    }

    @Override
    public boolean shouldFilter()
    {
        //se puede agregar una validacion en la solicitud
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Long startTime = (Long) request.getAttribute("start");
        Long endTime = System.currentTimeMillis();
        Long elapsedTime = endTime - startTime;
        log.info("Elapsed time {}ms", elapsedTime);
        return null;
    }
}
