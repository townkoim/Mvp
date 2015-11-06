package com.example.mvp.async;

import java.lang.ref.WeakReference;


/**
* @ClassName: WeakAsyncTask  
* @Description: 使用  WeakAsyncTask 来进行弱引用，来对Asnctask进行优化，WeakTarget最好是用Activity对象，防止Context 溢出
* @author libiao 
* @date 2015-11-6 下午2:38:06  
*  
* @param <Params>
* @param <Progress>
* @param <Result>
* @param <WeakTarget>
 */
public abstract class WeakAsyncTask<Params, Progress, Result, WeakTarget> extends BaseAsyncTask<Params, Progress, Result> {
	protected WeakReference<WeakTarget> mTarget;

	public WeakAsyncTask(WeakTarget target) {
		mTarget = new WeakReference<WeakTarget>(target);
	}

	/** {@inheritDoc} */
	@Override
	protected final void onPreExecute() {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			this.onPreExecute(target);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected final Result doInBackground(Params... params) {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			return this.doInBackground(target, params);
		} else {
			return null;
		}
	}

	/** {@inheritDoc} */
	@Override
	protected final void onPostExecute(Result result) {
		final WeakTarget target = mTarget.get();
		if (target != null) {
			this.onPostExecute(target, result);
		}
	}

	protected void onPreExecute(WeakTarget target) {
		// No default action
	}

	protected abstract Result doInBackground(WeakTarget target, Params... params);

	protected void onPostExecute(WeakTarget target, Result result) {
		// No default action
	}
}