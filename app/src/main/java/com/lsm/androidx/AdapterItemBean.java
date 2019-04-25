package com.lsm.androidx;

import androidx.annotation.LayoutRes;

/**
 * <p>
 *
 * </p>
 *
 * @author shiming
 * @version v1.0
 * @since 2019/4/1 14:08
 */
public class AdapterItemBean {


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    //指定默认的那个的Activity
    private  Class clazz=DemoActivity.class;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getLayoutID() {
        return layoutID;
    }

    public void setLayoutID(int layoutID) {
        this.layoutID = layoutID;
    }

    private String title;
    private String des;
    private @LayoutRes int layoutID;

    public AdapterItemBean(String title, String des, @LayoutRes int layoutID) {
        this.title = title;
        this.des = des;
        this.layoutID = layoutID;
    }


    public AdapterItemBean(String title, String des,  Class clazz) {
        this.title = title;
        this.des = des;
        this.clazz=clazz;
    }
}
