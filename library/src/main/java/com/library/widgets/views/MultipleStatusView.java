package com.library.widgets.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.library.R;


/**
 * 一个方便在多种状态切换的view<br/>
 * 作者：lzhs <br/>
 * 时间： 2016/10/28 0028 17:44<br/>
 * 邮箱：1050629507@qq.com
 */
public class MultipleStatusView extends RelativeLayout {
    public static final int STATUS_CONTENT = 0x1a;
    public static final int STATUS_LOADING = 0x2a;
    public static final int STATUS_EMPTY = 0x3a;
    public static final int STATUS_ERROR = 0x4a;
    public static final int STATUS_NO_NETWORK = 0x5a;

    private static final int NULL_RESOURCE_ID = -1;

    public View mEmptyView;
    private View mErrorView;
    private View mLoadingView;
    private View mNoNetworkView;
    private View mContentView;

    private int mEmptyViewResId;
    private int mErrorViewResId;
    private int mLoadingViewResId;
    private int mNoNetworkViewResId;
    private int mContentViewResId;

    private int mViewStatus;

    private LayoutInflater mInflater;
    private OnClickListener mOnClickListener;
    private final ViewGroup.LayoutParams mLayoutParams = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    public MultipleStatusView(Context context) {
        this(context, null);
    }

    public MultipleStatusView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleStatusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs, defStyleAttr);
    }


    /**
     * 初始化属性
     *
     * @param attrs
     * @param defStyleAttr
     */
    private void initAttrs(AttributeSet attrs, int defStyleAttr) {
        TypedArray arrs = getContext().obtainStyledAttributes(attrs, R.styleable.MultipleStatusView,
                defStyleAttr, 0);
        mEmptyViewResId = arrs.getResourceId(R.styleable.MultipleStatusView_emptyView,
                R.layout.view_empty);
        mErrorViewResId = arrs.getResourceId(R.styleable.MultipleStatusView_errorView,
                R.layout.view_error);
        mLoadingViewResId = arrs.getResourceId(R.styleable.MultipleStatusView_loadingView,
                R.layout.view_loading);
        mNoNetworkViewResId = arrs.getResourceId(R.styleable.MultipleStatusView_noNetworkView,
                R.layout.view_no_network);
        mContentViewResId = arrs.getResourceId(R.styleable.MultipleStatusView_contentView,
                NULL_RESOURCE_ID);
        arrs.recycle();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mInflater = LayoutInflater.from(getContext());
        showContent();
    }

    /**
     * 获取当前状态
     */
    public int getViewStatus() {
        return mViewStatus;
    }

    /**
     * 设置重试点击事件
     *
     * @param mOnClickListener 点击事件
     */
    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    /**
     * 显示空视图
     */
    public final void showEmpty() {
        mViewStatus = STATUS_EMPTY;
        if (null == mEmptyView) {
            mEmptyView = mInflater.inflate(mEmptyViewResId, null);
            if (null != mOnClickListener) {
                mEmptyView.setTag(mViewStatus);
                mEmptyView.setOnClickListener(mOnClickListener);
            }
            addView(mEmptyView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /**
     * 显示错误视图
     */
    public final void showError() {
        mViewStatus = STATUS_ERROR;
        if (null == mErrorView) {
            mErrorView = mInflater.inflate(mErrorViewResId, null);
            if (null != mOnClickListener) {
                mErrorView.setTag(mViewStatus);
                mErrorView.setOnClickListener(mOnClickListener);
            }
            addView(mErrorView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /**
     * 显示加载中视图
     */
    public final void showLoading() {
        mViewStatus = STATUS_LOADING;
        if (null == mLoadingView) {
            mLoadingView = mInflater.inflate(mLoadingViewResId, null);
            if (null != mOnClickListener) {
                mLoadingView.setTag(mViewStatus);
                mLoadingView.setOnClickListener(mOnClickListener);
            }
            addView(mLoadingView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /**
     * 显示无网络视图
     */
    public final void showNoNetwork() {
        mViewStatus = STATUS_NO_NETWORK;
        if (null == mNoNetworkView) {
            mNoNetworkView = mInflater.inflate(mNoNetworkViewResId, null);
            if (null != mOnClickListener) {
                mNoNetworkView.setTag(mViewStatus);
                mNoNetworkView.setOnClickListener(mOnClickListener);
            }
            addView(mNoNetworkView, 0, mLayoutParams);
        }
        showViewByStatus(mViewStatus);
    }

    /**
     * 显示内容视图
     */
    public final void showContent() {
        mViewStatus = STATUS_CONTENT;
        if (null == mContentView) {
            if (mContentViewResId != NULL_RESOURCE_ID) {
                mContentView = mInflater.inflate(mContentViewResId, null);
                addView(mContentView, 0, mLayoutParams);
            } else {
                mContentView = findViewById(R.id.MultipleStatusViewContent);
            }
        }
        showViewByStatus(mViewStatus);
    }


    private void showViewByStatus(int viewStatus) {
        if (null != mLoadingView)
            mLoadingView.setVisibility(viewStatus == STATUS_LOADING ? View.VISIBLE : View.GONE);
        if (null != mEmptyView)
            mEmptyView.setVisibility(viewStatus == STATUS_EMPTY ? View.VISIBLE : View.GONE);
        if (null != mErrorView)
            mErrorView.setVisibility(viewStatus == STATUS_ERROR ? View.VISIBLE : View.GONE);
        if (null != mNoNetworkView)
            mNoNetworkView.setVisibility(viewStatus == STATUS_NO_NETWORK ? View.VISIBLE : View
                    .GONE);
        if (null != mContentView)
            mContentView.setVisibility(viewStatus == STATUS_CONTENT ? View.VISIBLE : View.GONE);
    }


    public void setAgain(@NonNull OnClickListener mOnClickListener) {
        if (mErrorViewResId == R.layout.view_error)
            findViewById(R.id.mMultipleAgain).setOnClickListener(mOnClickListener);
    }

}
