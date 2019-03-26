package k.xy.my_lib_aspectj;

import android.util.Log;
import android.widget.Toast;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Locale;

@Aspect
public class MethodBehaviorAspect {

    private static final String TAG = "test_aspect";


    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodBefore: " + key+"\n"+joinPoint.getThis());
    }

//    @Pointcut("execution(@com.test.qby.aspectjlib.annotation.IFirstAnnotation * *(..))")
//    public void firstMethodAnnotationBehavior() {
//    }
//
//    @Pointcut("execution(* com.test.qby.newtestapplication.ui.MainActivity.aspectClick(android.view.View))")
//    public void secondMethodAnnotationBehavior() {
//    }
//
//    @Around("firstMethodAnnotationBehavior()")
//    public Object wavePointcutAround(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        // 类名
//        String className = methodSignature.getDeclaringType().getSimpleName();
//        // 方法名
//        String methodName = methodSignature.getName();
//        // 功能名
////        IFirstAnnotation behaviorTrace = methodSignature.getMethod()
////                .getAnnotation(IFirstAnnotation.class);
////        String value = behaviorTrace.value();
////        String value = "点击";
//        long start = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long duration = System.currentTimeMillis() - start;
////        Log.e(TAG, String.format("%s类中%s方法执行%s功能,耗时：%dms", className, methodName, value, duration));
////        Toast.makeText(MyApplication.getContext(), String.format(Locale.CHINESE, "%s类中%s方法执行%s功能,耗时：%dms", className, methodName, value, duration), Toast.LENGTH_SHORT).show();
//        return result;
//    }
}
//@Aspect指定切面类；
// @Pointcut切入点；
// @Around是切入方式Advice的一种，表示在切入点前后插入代码，
// 还有@Before、@After；execution执行时，
// 表示根据Advice在执行方法内部代码前后插入代码,
// 还有call调用时，
// 表示根据Advice在调用方法前后插入代码。
