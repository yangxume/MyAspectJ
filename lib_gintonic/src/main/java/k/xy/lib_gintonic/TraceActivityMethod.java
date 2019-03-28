package k.xy.lib_gintonic;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class TraceActivityMethod {

    private static final String TAG = LogTag.TAG_ACTIVITY;

    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {

        Signature signature = joinPoint.getSignature();

        Object target = joinPoint.getTarget();

        Object aThis = joinPoint.getThis();

        Object[] args = joinPoint.getArgs();

        String kind = joinPoint.getKind();

        SourceLocation sourceLocation = joinPoint.getSourceLocation();

        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();

        Log.d(TAG, "onActivityMethodBefore: signature = " + signature.toString());
        Log.d(TAG, "onActivityMethodBefore: target = " + target.toString());
        Log.d(TAG, "onActivityMethodBefore: aThis = " + aThis.toString());

        for (int i = 0; i < args.length; i++) {
            Log.d(TAG, "onActivityMethodBefore: args = "+i+"--"+ args[i]);
        }

        Log.d(TAG, "onActivityMethodBefore: kind = " + kind.toString());
        Log.d(TAG, "onActivityMethodBefore: sourceLocation = " + sourceLocation.toString());
        Log.d(TAG, "onActivityMethodBefore: staticPart = " + staticPart.toString());


    }

    //执行结果：

//    2019-03-28 15:26:02.851 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: signature = void k.xy.myaspectj.MainActivity.onCreate(Bundle)
//            2019-03-28 15:26:02.852 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: target = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:02.853 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: aThis = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:02.853 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: args = [Ljava.lang.Object;@1880bd7
//2019-03-28 15:26:02.854 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: kind = method-execution
//2019-03-28 15:26:02.854 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: sourceLocation = MainActivity.java:21
//            2019-03-28 15:26:02.854 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: staticPart = execution(void k.xy.myaspectj.MainActivity.onCreate(Bundle))
//            2019-03-28 15:26:03.109 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: signature = void k.xy.myaspectj.MainActivity.onStart()
//            2019-03-28 15:26:03.110 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: target = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:03.110 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: aThis = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:03.110 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: kind = method-execution
//2019-03-28 15:26:03.110 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: sourceLocation = MainActivity.java:37
//            2019-03-28 15:26:03.110 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: staticPart = execution(void k.xy.myaspectj.MainActivity.onStart())
//            2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: signature = void k.xy.myaspectj.MainActivity.onResume()
//            2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: target = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: aThis = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: kind = method-execution
//2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: sourceLocation = MainActivity.java:32
//            2019-03-28 15:26:03.116 11067-11067/k.xy.myaspectj D/TraceAspect: onActivityMethodBefore: staticPart = execution(void k.xy.myaspectj.MainActivity.onResume())



}
//        原文：https://blog.csdn.net/XiNanHeiShao/article/details/74082605
