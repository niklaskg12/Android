// Copyright 2011 Google Inc. All Rights Reserved.

package com.google.ads.interactivemedia.v3.samples.demoapp.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback;

/**
 * A VideoView that intercepts various methods and reports them back to a set of
 * VideoAdPlayerCallbacks.
 */
public class TrackingVideoView extends VideoView implements OnCompletionListener, OnErrorListener, OnPreparedListener {
	
	private ImageView ivLoadingIndicator = null; // Added by RenZhe Ahn
	private AnimationDrawable loadingIndicatorAnimation; // Animation for loading indicator, Added by RenZhe Ahn
	private Timer loadingTimer = null; // timer for loading video, Added by RenZhe Ahn 
	
  /** Interface for alerting caller of video completion. */
	public interface CompleteCallback {
		public void onComplete();
	}

	private enum PlaybackState {
		STOPPED, PAUSED, PLAYING
	}

	private final List<VideoAdPlayerCallback> adCallbacks = new ArrayList<VideoAdPlayerCallback>(1);
	private CompleteCallback completeCallback;
	private PlaybackState state = PlaybackState.STOPPED;

	public TrackingVideoView(Context context) {
		super(context);
		super.setOnPreparedListener(this); // Added by RenZhe Ahn
		super.setOnCompletionListener(this);
		super.setOnErrorListener(this);
		
	}

	public void setLoadingIndicator(ImageView loadingIndicator) { // Added by RenZhe Ahn
		ivLoadingIndicator = loadingIndicator;
		loadingIndicatorAnimation = (AnimationDrawable) ivLoadingIndicator.getBackground();
	}

	public void setCompleteCallback(CompleteCallback callback) {
		this.completeCallback = callback;
	}

	public void togglePlayback() {
		switch(state) {
			case STOPPED:
			case PAUSED:
				start();
				break;
			case PLAYING:
				pause();
				break;
		}
	}

	@Override
	public void start() {
		super.start();
		
		PlaybackState oldState = state;
		state = PlaybackState.PLAYING;

		switch (oldState) {
			case STOPPED:
				for (VideoAdPlayerCallback callback : adCallbacks) {
					callback.onPlay();
				}
				break;
			case PAUSED:
				for (VideoAdPlayerCallback callback : adCallbacks) {
					callback.onResume();
				}
				break;
			default:
				// Already playing; do nothing.
		}
	}

	@Override
	public void pause() {
		super.pause();
		state = PlaybackState.PAUSED;

		for (VideoAdPlayerCallback callback : adCallbacks) {
			callback.onPause();
		}
	}

	@Override
	public void stopPlayback() {
		super.stopPlayback();
		onStop();
	}

	private void onStop() {
		if (state == PlaybackState.STOPPED) {
			return; // Already stopped; do nothing.
		}

		state = PlaybackState.STOPPED;
	}

	@Override
	public void onPrepared(MediaPlayer mp) { // Added by RenZhe Ahn
		// TODO Auto-generated method stub
		if (ivLoadingIndicator != null) {
			loadingTimer = new Timer("preparing progress updater");  
			loadingTimer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Activity activity = (Activity) getContext();
					activity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								if (TrackingVideoView.this.getCurrentPosition()>0 && TrackingVideoView.this.isPlaying()) { // if video has already started playing
									stopLoadingIndicator();
								} else { 
									ivLoadingIndicator.setVisibility(View.VISIBLE); // show loading image
								}
							} catch (Exception e) {
								stopLoadingIndicator();
								e.printStackTrace();
							}
						}
					});	
				}
			}, 0, 500);
		}
	}

	@Override
	public void onCompletion(MediaPlayer mp) {
		onStop();
		for (VideoAdPlayerCallback callback : adCallbacks) {
			callback.onEnded();
		} 
		completeCallback.onComplete();
	}

	@Override
	public boolean onError(MediaPlayer mp, int what, int extra) {
		stopLoadingIndicator();
		for (VideoAdPlayerCallback callback : adCallbacks) {
			callback.onError();
		}
		onStop();
		// Returning true signals to MediaPlayer that we handled the error. This will prevent the
		// completion handler from being called.
		return true;
	}

	public void addCallback(VideoAdPlayerCallback callback) {
		adCallbacks.add(callback);
	}

	public void removeCallback(VideoAdPlayerCallback callback) {
		adCallbacks.remove(callback);
	}

	@Override
	public void setOnCompletionListener(OnCompletionListener l) {
		throw new UnsupportedOperationException();
	}
	
	public void stopLoadingIndicator() { // Added by RenZhe
		if (loadingTimer != null) {
			loadingTimer.cancel();
			ivLoadingIndicator.setVisibility(View.INVISIBLE); // hide loading image
			loadingIndicatorAnimation.stop();
		}
	}
}