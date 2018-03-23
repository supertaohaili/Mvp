// Generated code from Butter Knife. Do not modify!
package com.thl.mvp.demo.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.droidlover.xrecyclerview.XRecyclerContentLayout;
import com.thl.mvp.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BasePagerFragment_ViewBinding<T extends BasePagerFragment> implements Unbinder {
  protected T target;

  @UiThread
  public BasePagerFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.contentLayout = Utils.findRequiredViewAsType(source, R.id.contentLayout, "field 'contentLayout'", XRecyclerContentLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.contentLayout = null;

    this.target = null;
  }
}
