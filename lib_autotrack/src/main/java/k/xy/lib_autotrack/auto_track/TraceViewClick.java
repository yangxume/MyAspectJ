package k.xy.lib_autotrack.auto_track;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import k.xy.lib_autotrack.util.LogTag;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
public class TraceViewClick {

    private static final String TAG = LogTag.TAG_ASPECTJ;


    @After("execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(..))")
    public void onViewItemClickAop(final JoinPoint joinPoint) throws Throwable{

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

        Log.d(TAG, "onViewItemClickAop: signature = " + signature.toString());
        Log.d(TAG, "onViewItemClickAop: target = " + target.toString());
        Log.d(TAG, "onViewItemClickAop: aThis = " + aThis.toString());

        for (int i = 0; i < args.length; i++) {
            Log.d(TAG, "onViewItemClickAop: args = "+i+"--" + args[i]);

//            View view = (View) args[i];

//            if (view instanceof Button
//                    || view instanceof RadioButton
//                    || view instanceof CheckBox
//                    || view instanceof TextView){
//
//                TextView textView = (TextView) args[i];
//
//                /**
//                 * 获取被点击控件文本内容
//                 */
//                CharSequence text = textView.getText();
//                /**
//                 * 获取被点击控件id
//                 */
//                int id = textView.getId();
//
//                Log.d(TAG, "onViewItemClickAop: args["+i+"]-viewId is -" + id);
//                Log.d(TAG, "onViewItemClickAop: args["+i+"]-text is -" + text);
//
//            }
        }

        Log.d(TAG, "onViewItemClickAop: kind = " + kind.toString());
        Log.d(TAG, "onViewItemClickAop: sourceLocation = " + sourceLocation.toString());
        Log.d(TAG, "onViewItemClickAop: staticPart = " + staticPart.toString());

        // 执行结果：
//        2019-03-28 16:58:43.622 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: signature = void k.xy.myaspectj.MainActivity.onItemClick(AdapterView, View, int, long)
//        2019-03-28 16:58:43.622 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: target = k.xy.myaspectj.MainActivity@a61af56
//        2019-03-28 16:58:43.622 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: aThis = k.xy.myaspectj.MainActivity@a61af56
//        2019-03-28 16:58:43.622 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: args = 0--android.widget.ListView{aac239f VFED.VC.. .F....ID 0,212-450,1112 #7f070050 app:id/listview}
//        2019-03-28 16:58:43.622 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: args = 1--android.support.v7.widget.AppCompatTextView{a1fccec V.ED..... ........ 0,0-450,72 #1020014 android:id/text1}
//        2019-03-28 16:58:43.623 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: args[1]-viewId is -16908308
//        2019-03-28 16:58:43.623 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: args[1]-text is -a
//        2019-03-28 16:58:43.623 13853-13853/k.xy.myaspectj D/tag_view_click: onViewItemClickAop: args = 2--0



    }


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
//
//2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: signature = void k.xy.myaspectj.MainActivity.onClick(View)2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: target = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: aThis = k.xy.myaspectj.MainActivity@a61af56
//2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: args = 0--android.support.v7.widget.AppCompatButton{6fba93e VFED..C.. ...P.... 8,8-308,98 #7f070022 app:id/btn01}
//2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: args[0]-viewId is -2131165218 2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: args[0]-text is -btn01_text
//2019-03-28 16:05:55.078 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: kind = method-execution
//2019-03-28 16:05:55.079 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: sourceLocation = MainActivity.java:59
//2019-03-28 16:05:55.079 12940-12940/k.xy.myaspectj D/tag_view_click: onViewClickAop: staticPart = execution(void k.xy.myaspectj.MainActivity.onClick(View))
//

}
