package com.zzx;

import com.zzx.feign.UserOrderFeign;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
class UserServiceApplicationTests {

    @Resource
    private RestTemplate restTemplate;

    @Test
    void contextLoads() {
    }


    @Test
    public void testFeignBySelf() {

        UserOrderFeign userOrderFeignProxyInstance = (UserOrderFeign) Proxy.newProxyInstance(UserOrderFeign.class.getClassLoader(), new Class[]{UserOrderFeign.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                /**
                 * 远程调用核心实现
                 */

                //拿到方法的注解
                GetMapping annotation = method.getAnnotation(GetMapping.class);

                //拿到值，也就是远程调用的接口API
                String[] value = annotation.value();

                String remoteApi=value[0];

                System.out.println("远程调用的接口是:"+remoteApi);

                //现在拿到了API，还差ip和port【这个需要使用微服务名称，联合ribbon去注册中心拿到一个ip+port】

                //先拿到这个方法所在的类，类就是加了@FeignClient的这个类，可以来拿到微服务名称
                Class<?> declaringClass = method.getDeclaringClass();

                System.out.println("方法所在的类的名称:"+declaringClass.getSimpleName());

                FeignClient feignClient = declaringClass.getAnnotation(FeignClient.class);

                String serviceName = feignClient.value();

                System.out.println("方法所调用的微服务名称:"+serviceName);

                //拿到了微服务名称，就可以通过ribbon和restTemplate来发起请求了

                String url="http://"+serviceName+remoteApi;

                System.out.println(url);

                String forObject = restTemplate.getForObject(url, String.class);

                return forObject;

            }
        });

        String s = userOrderFeignProxyInstance.orderService();
        System.out.println("======="+s+"=======");
    }

}
