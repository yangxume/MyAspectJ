package k.xy.lib_gintonic;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class TraceViewClick {

    private static final String TAG = LogTag.TAG_VIEW_CLICK;

    /**
     * android.view.View.OnClickListener.onClick(android.view.View)
     *
     * @param joinPoint JoinPoint
     * @throws Throwable Exception
     */
    @After("execution(* android.view.View.OnClickListener.onClick(android.view.View))")
    public void onViewClickAop(final JoinPoint joinPoint) throws Throwable {


        Signature signature = joinPoint.getSignature();

        Object target = joinPoint.getTarget();

        Object aThis = joinPoint.getThis();

        /**
         * 所有view对象集合
         */
        Object[] args = joinPoint.getArgs();

        /**
         *
         */
        String kind = joinPoint.getKind();

        /**
         * 当前执行代码所在类行数
         * eg: MainActivity.java:59
         */
        SourceLocation sourceLocation = joinPoint.getSourceLocation();

        /**
         * 完整包名+类名+当前执行的方法名
         * eg：execution(void k.xy.myaspectj.MainActivity.onClick(View))
         */
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();

        Log.d(TAG, "onViewClickAop: signature = " + signature.toString());
        Log.d(TAG, "onViewClickAop: target = " + target.toString());
        Log.d(TAG, "onViewClickAop: aThis = " + aThis.toString());

        for (int i = 0; i < args.length; i++) {
            Log.d(TAG, "onViewClickAop: args = "+i+"--" + args[i]);

            View view = (View) args[i];

            if (view instanceof Button
                    || view instanceof RadioButton
                    || view instanceof CheckBox
                    || view instanceof TextView){

                TextView textView = (TextView) args[i];

                /**
                 * 获取被点击控件文本内容
                 */
                CharSequence text = textView.getText();
                /**
                 * 获取被点击控件id
                 */
                int id = textView.getId();

                Log.d(TAG, "onViewClickAop: args["+i+"]-viewId is -" + id);
                Log.d(TAG, "onViewClickAop: args["+i+"]-text is -" + text);

            }
        }

        Log.d(TAG, "onViewClickAop: kind = " + kind.toString());
        Log.d(TAG, "onViewClickAop: sourceLocation = " + sourceLocation.toString());
        Log.d(TAG, "onViewClickAop: staticPart = " + staticPart.toString());


    }

}
