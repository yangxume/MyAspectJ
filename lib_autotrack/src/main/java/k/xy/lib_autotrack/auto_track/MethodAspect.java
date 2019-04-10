//package k.xy.lib_gintonic;
//
//import android.telephony.mbms.MbmsErrors;
//import android.util.Log;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//
///**
// * //    链接：https://www.jianshu.com/p/f90e04bcb326
// */
//
//@Aspect
//public class MethodAspect {
//
//    private static final String TAG = MethodAspect.class.getSimpleName();
//
//    //1.定义一个 Animal 类，包含一个 fly 方法
//
//
//    /**
//     * 2.使用 @Pointcut 来注解方法，定义具体的 Pointcut ，call(MethodSignature) 关键字表示方法被调用
//     * <p>
//     * MethodSignature 的定义参考： @注解 访问权限 返回值类型 类名.函数名(参数)
//     */
//
//    //方式一：
//    @Pointcut("call (*k.xy.lib_gintonic.Animal.fly(..))")
//    public void callMethod() {
//    }
//
//    //在调用 fly 的地方，之前插入一段代码：
//    @Before("callMethod()")
//    public void beforeMethodCall(JoinPoint joinPoint) {
//
//        Log.e(TAG, "beforeMethodCall: ");
//        Log.e(TAG, "beforeMethodCall: getTarget = " + joinPoint.getTarget().toString());
//        Log.e(TAG, "beforeMethodCall: getSignature = " + joinPoint.getSignature());
//        Log.e(TAG, "beforeMethodCall: getSignature().getName = " + joinPoint.getSignature().getName());
//
//    }
//
//    //方式二：
////    调用 fly 之前插入一段代码，所以 Advice 需要使用 @Before，@Before 的参数就是 使用@Pointcut 注解的方法名称。
////    当然，你也可以合并 Pointcut 和 Advice，像这样：
////    @Before("call(* k.xy.lib_gintonic.Animal.fly(..))")
////    public void beforeMethodCall(JoinPoint joinPoint) {
////        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
////    }
//
//
//    /**
//     * android.view.View.OnClickListener.onClick(android.view.View)
//     *
//     * @param joinPoint JoinPoint
//     * @throws Throwable Exception
//     */
//    @After("call(* android.view.View.OnClickListener.onClick(..))")
//    public void onViewClickAOP(final JoinPoint joinPoint) throws Throwable {
//
//        String key = joinPoint.getSignature().toString();
//        Log.d(TAG, "onViewClickAOP: " + key+"\n"+joinPoint.getThis());
//
//    }
//
//}
