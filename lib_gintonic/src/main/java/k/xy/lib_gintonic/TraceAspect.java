package k.xy.lib_gintonic;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TraceAspect {

    //ydc start
    private static final String TAG = "ydc";
    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodBefore: " + key+"\n"+joinPoint.getThis());
    }

    /**
     * android.view.View.OnClickListener.onClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("call(* android.view.View.OnClickListener.onClick(..))")
    public void onViewClickAOP(final JoinPoint joinPoint) throws Throwable {

        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onViewClickAOP: " + key+"\n"+joinPoint.getThis());

    }


}
//        原文：https://blog.csdn.net/XiNanHeiShao/article/details/74082605
