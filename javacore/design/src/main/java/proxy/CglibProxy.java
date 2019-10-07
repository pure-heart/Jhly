package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**创建CGLIB代理类
 * @Auther:JHLY
 * @Date:2019/10/7
 * @Description:proxy
 * @Version:1.0
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

     public Object getInstance(final Object target) {
                 this.target = target;
                 Enhancer enhancer = new Enhancer();
                 enhancer.setSuperclass(this.target.getClass());
                 enhancer.setCallback(this);
                 return enhancer.create();
             }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("买房前准备");
                 Object result = methodProxy.invoke(o, objects);
                 System.out.println("买房后装修");
                 return result;
    }
}
