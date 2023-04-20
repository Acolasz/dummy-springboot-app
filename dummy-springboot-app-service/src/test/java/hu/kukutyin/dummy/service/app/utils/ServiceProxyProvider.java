package hu.kukutyin.dummy.service.app.utils;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.DefaultAopProxyFactory;

import hu.kukutyin.dummy.service.app.aop.logging.LoggingAspect;

public final class ServiceProxyProvider {

    private ServiceProxyProvider() {
        // helper
    }

    public static Object getServiceProxy(Object service) {
        final LoggingAspect entryExitAspect = new LoggingAspect();
        final AspectJProxyFactory proxyFactory = new AspectJProxyFactory(service);
        proxyFactory.addAspect(entryExitAspect);

        final AopProxy aopProxy = new DefaultAopProxyFactory().createAopProxy(proxyFactory);

        return aopProxy.getProxy();
    }
}
