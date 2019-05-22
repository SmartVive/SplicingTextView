package com.ehomecare.splicingtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.Arrays;

public class SplicingTextView extends android.support.v7.widget.AppCompatTextView {
    private String splicingText;
    private String emptyContentText;

    public SplicingTextView(Context context) {
        this(context, null);
    }

    public SplicingTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SplicingTextView);
        splicingText = array.getString(R.styleable.SplicingTextView_splicingText);
        emptyContentText = array.getString(R.styleable.SplicingTextView_emptyContentText);
        array.recycle();

        init();
    }

    private void init() {
        if (splicingText != null){
            Object[] split = splicingText.split("%");
            Object[] arrayString = new String[split.length - 1];
            Arrays.fill(arrayString, "");
            setText(String.format(splicingText, arrayString));
        }


        if (emptyContentText == null){
            emptyContentText = "";
        }
    }


    public void setContentText(String... contents) {
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] == null || contents[i].isEmpty()) {
                contents[i] = emptyContentText;
            }
        }

        if (splicingText != null && !splicingText.isEmpty()) {
            String format = String.format(splicingText, (Object[]) contents);
            setText(format);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (String content:contents){
                stringBuilder.append(content);
            }
            setText(stringBuilder);
        }
    }


    /**
     * @param emptyContentText 空数据填充
     */
    public void setEmptyContentText(String emptyContentText) {
        this.emptyContentText = emptyContentText;
    }
}
