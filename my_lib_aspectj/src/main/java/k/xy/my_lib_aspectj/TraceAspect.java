package k.xy.my_lib_aspectj;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class TraceAspect {

    private static final String TAG = "test_aspect";


    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onActivityMethodBefore: " + key + "\n" + joinPoint.getThis());
    }



    private static Object currentObject = null;
    //进行类似于正则表达式的匹配，被匹配到的方法都会被截获
    ////截获任何包中以类名以Activity、Layout结尾，并且该目标类和当前类是一个Object的对象的所有方法
    private static final String POINTCUT_METHOD =
            "(execution(* *..Activity+.*(..)) ||execution(* *..Layout+.*(..))) && target(Object) && this(Object)";
    //精确截获MyFrameLayou的onMeasure方法
    private static final String POINTCUT_CALL = "call(* org.android10.viewgroupperformance.component.MyFrameLayout.onMeasure(..))";

    private static final String POINTCUT_METHOD_MAINACTIVITY = "execution(* *..MainActivity+.onCreate(..))";

    //切点，ajc会将切点对应的Advise编织入目标程序当中
    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotated() {}
    @Pointcut(POINTCUT_METHOD_MAINACTIVITY)
    public void methodAnootatedWith(){}

    /**
     * 在截获的目标方法调用之前执行该Advise
     * @param joinPoint
     * @throws Throwable
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Before("methodAnootatedWith()")
    public void onCreateBefore(JoinPoint joinPoint) throws Throwable{
        Activity activity = null;
        //获取目标对象
        activity = ((Activity)joinPoint.getTarget());

        //插入自己的实现，控制目标对象的执行
//        ChooseDialog dialog = new ChooseDialog(activity);
//        dialog.show();

        Log.e(TAG,activity.getLocalClassName());

        //做其他的操作
        buildLogMessage("test",20);
    }
    /**
     * 在截获的目标方法调用返回之后（无论正常还是异常）执行该Advise
     * @param joinPoint
     * @throws Throwable
     */
    @After("methodAnootatedWith()")
    public void onCreateAfter(JoinPoint joinPoint) throws Throwable{
        Log.e(TAG,"onCreate is end .");

    }
    /**
     * 在截获的目标方法体开始执行时（刚进入该方法实体时）调用
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("methodAnnotated()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        if (currentObject == null){
            currentObject = joinPoint.getTarget();
        }
//        //初始化计时器
//        final StopWatch stopWatch = new StopWatch();
//        //开始监听
//        stopWatch.start();
//        //调用原方法的执行。
        Object result = joinPoint.proceed();
//        //监听结束
//        stopWatch.stop();
        //获取方法信息对象
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className;
        //获取当前对象，通过反射获取类别详细信息
        className = joinPoint.getThis().getClass().getName();

        String methodName = methodSignature.getName();
//        if (currentObject != null && currentObject.equals(joinPoint.getTarget())){
//            DebugLog.log(new MethodMsg(className, buildLogMessage(methodName, stopWatch.getTotalTimeMicros()),stopWatch.getTotalTimeMicros()));
//        }else if(currentObject != null && !currentObject.equals(joinPoint.getTarget())){
//            DebugLog.log(new MethodMsg(className, buildLogMessage(methodName, stopWatch.getTotalTimeMicros()),stopWatch.getTotalTimeMicros()));
//            currentObject = joinPoint.getTarget();
//            DebugLog.outPut(new Path());    //日志存储
//            DebugLog.ReadIn(new Path());    //日志读取
//        }
        Log.e(TAG,"result : "+result);

        return result;
    }

    /**
     * 创建一个日志信息
     *
     * @param methodName 方法名
     * @param methodDuration 执行时间
     * @return
     */
    private static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
//        if (StopWatch.Accuracy == 1){
//            message.append("ms");
//        }else {
//            message.append("mic");
//        }
        message.append("]      ");

        return message.toString();
    }

//    原文：https://blog.csdn.net/woshimalingyi/article/details/51476559

}