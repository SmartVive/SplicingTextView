SplicingTextView可拼接String的TextView
------------------
 app:splicingText为拼接的内容，以%s作为占位符
 <br/>
 app:emptyContentText为当内容为空时显示的字符串

    <com.ehomecare.business.widget.SplicingTextView
                android:id="@+id/tvName"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                app:splicingText="姓名：%s,年龄：%s,信息：%s"
                app:emptyContentText="无"/>
                
                
    tvName.setContentText("李磊",20，null)
    

最终显示为：姓名：李磊，年龄：20，空
