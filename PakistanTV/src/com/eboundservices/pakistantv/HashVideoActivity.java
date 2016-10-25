package com.eboundservices.pakistantv;

import java.util.Timer;
import java.util.regex.Pattern;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsLoader.AdsLoadedListener;
import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.samples.demoapp.player.AdVideoPlayer;
import com.google.ads.interactivemedia.v3.samples.demoapp.player.TrackingVideoView.CompleteCallback;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HashVideoActivity extends Activity 
	implements OnClickListener, 
			   AdErrorListener,
			   AdsLoadedListener,
			   AdEventListener,
			   CompleteCallback {
	
	private final String TAG = HashVideoActivity.class.getSimpleName();
	private String _packageName; // main app package name
	
	//private static final String CONTENT_URL = "http://rmcdn.2mdn.net/MotifFiles/html/1248596/" + "android_1330378998288.mp4"; // Sample Url

	//private String adTagUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=400x300&iu=%2F6062%2Fhanna_MA_group%2Fvideo_comp_app&ciu_szs=&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&m_ast=vast&url=[referrer_url]&correlator=[timestamp]";
	//private String adTagUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=400x300&iu=%2F6062%2Fhanna_MA_group%2Fwrapper_with_comp&ciu_szs=728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&m_ast=vast&url=[referrer_url]&correlator=[timestamp]";								 
	//private String adTagUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=%2F15018773%2Feverything2&ciu_szs=300x250%2C468x60%2C728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=[referrer_url]&correlator=[timestamp]&cmsid=133&vid=10XWSh7W4so&ad_rule=1";
	//private String adTagUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=/17308799/EBSN_VTAG&ciu_szs&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=eboundservices.com&correlator=[timestamp]";
	private String adTagUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=400x300&iu=%2F6062%2Fhanna_MA_group%2Fwrapper_with_comp&ciu_szs=728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&m_ast=vast&correlator=[timestamp]";
	
	private final int STREAM_TYPE = 1;
	private final int VOD_TYPE = 2;
	
	private boolean exception = false;

	protected boolean isAdStarted;
	protected boolean isAdPlaying;
	protected boolean contentStarted = false;

	private String stream = null; // stream(or vod file) name
	private int type = 0; // type for stream or vod
	private String date = null; // date for vod file
	private String streamUrl = null; // real hashed stream url 
	
	private ImageView ivLoading; // Image View for loading indicator
	private ImageButton ibClose; // Image Button for close icon
	private ImageButton ibFeedback; // Image Button for showing feedback dialog 
	private AnimationDrawable frameAnimation; // Animation for loading indicator
	private AdVideoPlayer videoPlayer; // Video player with ima ad
	
	private EditText etEmail = null; // Edit Text for email address in feedback dialog
	private EditText etFeedback = null; // Edit Text for feedback message in feedback dialog
	private Dialog feedbackDlg = null; // Dialog for feedback

	protected ImaSdkFactory sdkFactory;
	protected ImaSdkSettings sdkSettings;
	protected AdsLoader adsLoader;
    protected AdsManager adsManager;
	protected AdDisplayContainer container;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// remove status and title bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		_packageName = getApplicationContext().getPackageName();
		 
		final float scale = this.getResources().getDisplayMetrics().density;

		// Creating a new RelativeLayout
		RelativeLayout rlRootContainer = new RelativeLayout(this);
		// Defining the RelativeLayout layout parameters.
		RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		rlRootContainer.setGravity(Gravity.CENTER);
		
		// Creating a Video Player 
		if (videoPlayer == null) {
			videoPlayer = new AdVideoPlayer(this);
		    videoPlayer.setCompletionCallback(this);
		}
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		videoPlayer.setLayoutParams(params);
		rlRootContainer.addView(videoPlayer);		
		
		// Creating a Image View for loading animation image
		ivLoading = new ImageView(this);
		params = new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		ivLoading.setLayoutParams(params);
		ivLoading.setBackgroundResource(getResources().getIdentifier("hashvideo_loading", "drawable", _packageName)); 
		ivLoading.setVisibility(View.INVISIBLE);
		// Get the background, which has been compiled to an AnimationDrawable object.
		frameAnimation = (AnimationDrawable) ivLoading.getBackground();
		rlRootContainer.addView(ivLoading);		
		
		videoPlayer.setLoadingIndicator(ivLoading);
		
		// Creating a Image Button for cross icon
		ibClose = new ImageButton(this);
		params = new RelativeLayout.LayoutParams((int)(50*scale), (int)(50*scale));
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.setMargins((int)(5*scale), (int)(5*scale), 0, 0);
		ibClose.setId(1);
		ibClose.setLayoutParams(params);
		ibClose.setBackgroundResource(getResources().getIdentifier("close_icon", "drawable", _packageName)); 
		ibClose.setVisibility(View.INVISIBLE);
		ibClose.setOnClickListener(this);
		rlRootContainer.addView(ibClose);		
		
		// Creating a Image Button for feedback icon
		ibFeedback = new ImageButton(this);
		params = new RelativeLayout.LayoutParams((int)(50*scale), (int)(50*scale));
		params.setMargins((int)(5*scale), (int)(25*scale), 0, 0);
		params.addRule(RelativeLayout.BELOW, ibClose.getId()); 
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.setMargins(0, 0, (int)(5*scale), (int)(5*scale));
		ibFeedback.setLayoutParams(params);
		ibFeedback.setBackgroundResource(getResources().getIdentifier("feedback_icon", "drawable", _packageName)); 
		ibFeedback.setVisibility(View.INVISIBLE);
		ibFeedback.setOnClickListener(this);
		rlRootContainer.addView(ibFeedback);	

		setContentView(rlRootContainer, rlp);

		sdkFactory = ImaSdkFactory.getInstance();
	    createAdsLoader();
	    
		getAdEnabled();

		ibClose.bringToFront();
		ibClose.setVisibility(View.VISIBLE); // show close icon	
		
		ibFeedback.bringToFront();
		ibFeedback.setVisibility(View.VISIBLE); // show feedback icon
	}

	@Override
	protected void onPause() {
		super.onPause();
		// TODO Auto-generated method stub
		if (videoPlayer != null) {
			videoPlayer.savePosition();			
		}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Switch orientation as landscape
		
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// TODO Auto-generated method stub
		if (stream == null) { // If activity is started firstly
			Bundle extras = getIntent().getExtras(); 
			if (extras == null) finish();
			else { // get all intent extra params 
				type = extras.getInt("type", 0); 
				if (type == STREAM_TYPE) {
					stream = extras.getString("stream_name", null);
				} else {
					date = extras.getString("vod_date", null);
					stream = extras.getString("vod_name", null);
				}
			}
		} else {
			videoPlayer.restorePosition();
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		closeAll();
		
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		//outState.putInt("videostream_position", _videostream_position);
		outState.putInt("type", type);
		outState.putString("date", date);
		outState.putString("stream", stream);
		super.onSaveInstanceState(outState);
	}
		
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		type = savedInstanceState.getInt("type", 0);
		date = savedInstanceState.getString("date", "1");
		stream = savedInstanceState.getString("stream", null);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return closeAll();
		} else if (keyCode == KeyEvent.KEYCODE_HOME) { 
			return closeAll();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == ibClose) {
			closeAll();
		} else if (v == ibFeedback) {
			showFeedbackDialog();
		}
	}
	
	public boolean closeAll() {
		type = 0;
		stream = null;
		streamUrl = null;
		
		if (videoPlayer != null) {
			videoPlayer.stopAd();
			videoPlayer.stopLoadingIndicator();
			videoPlayer = null;
		}
		
		finish();
		return true;
	}
	
	//==================================================
	// implemenation override methods for ima enabled video player
	//==================================================
	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		if ( videoPlayer.isContentPlaying() ) {
		      adsLoader.contentComplete();
		}
	}

	@Override
	public void onAdEvent(AdEvent event) {
		// TODO Auto-generated method stub
		log("Event:" + event.getType());

	    switch (event.getType()) {
	      	case LOADED:
	      		adsManager.start();
	      		break;
	      	case CONTENT_PAUSE_REQUESTED:
	      		if (contentStarted) {
	      			videoPlayer.pauseContent();
	      		}
	      		break;
	      	case CONTENT_RESUME_REQUESTED:
	      		if (contentStarted) {
	      			videoPlayer.resumeContent();
	      		} else {
	      			getVideoUrlFormat();
	      		}
	      		break;
	      	case STARTED:
	      		isAdStarted = true;
	      		isAdPlaying = true;
	      		
				//ivLoading.setVisibility(View.INVISIBLE); // show loading image
				//frameAnimation.stop(); // start animation for loading
	      		break;
	      	case COMPLETED:
	      		isAdStarted = false;
	      		isAdPlaying = false;
	      		break;
	      	case ALL_ADS_COMPLETED:
	      		isAdStarted = false;
	      		isAdPlaying = false;
	      		adsManager.destroy();
	      		break;
	      	case PAUSED:
	      		isAdPlaying = false;
	      		break;
	      	case RESUMED:
	      		isAdPlaying = true;
	      		break;
	      	default:
	      		break;
	    }
	}

	@Override
	public void onAdsManagerLoaded(AdsManagerLoadedEvent event) {
		// TODO Auto-generated method stub
		log("Ads loaded!");
	    adsManager = event.getAdsManager();
	    adsManager.addAdErrorListener(this);
	    adsManager.addAdEventListener(this);
	    log("Calling init.");
	    adsManager.init();
	}

	@Override
	public void onAdError(AdErrorEvent event) {
		// TODO Auto-generated method stub
		log(event.getError().getMessage());

		//ivLoading.setVisibility(View.INVISIBLE); // show loading image
		//frameAnimation.stop(); // start animation for loading
		
		getVideoUrlFormat();
	}
	
	//==================================================
	// Methods for IMA ads sdk and settings
	//==================================================
	protected void createAdsLoader() {
	    adsLoader = sdkFactory.createAdsLoader(this, getImaSdkSettings());
	    adsLoader.addAdErrorListener(this);
	    adsLoader.addAdsLoadedListener(this);
	}
	 
	protected ImaSdkSettings getImaSdkSettings() {
	    if (sdkSettings == null) {
	    	sdkSettings = sdkFactory.createImaSdkSettings();
	    }
		return sdkSettings;
	}
	
	protected void pauseResumeAd() {
	    if (isAdStarted) {
	    	if (isAdPlaying) {
	    		log("Pausing video");
	    		videoPlayer.pauseAd();
	      } else {
	    	  log("Resuming video");
	    	  videoPlayer.resumeAd();
	      }
	    }
	}
	
	protected AdsRequest buildAdsRequest() {
	    container = sdkFactory.createAdDisplayContainer();
	    container.setPlayer(videoPlayer);
	    container.setAdContainer(videoPlayer.getUiContainer());
	    log("Requesting ads");
	    AdsRequest request = sdkFactory.createAdsRequest();
	    request.setAdTagUrl(adTagUrl);

//	    ArrayList<CompanionAdSlot> companionAdSlots = new ArrayList<CompanionAdSlot>();

//	    CompanionAdSlot companionAdSlot = sdkFactory.createCompanionAdSlot();
//	    companionAdSlot.setContainer(companionView);
//	    companionAdSlot.setSize(300, 50);
//	    companionAdSlots.add(companionAdSlot);
//
//	    if (leaderboardCompanionView != null) {
//	      CompanionAdSlot leaderboardCompanionAdSlot = sdkFactory.createCompanionAdSlot();
//	      leaderboardCompanionAdSlot.setContainer(leaderboardCompanionView);
//	      leaderboardCompanionAdSlot.setSize(728, 90);
//	      companionAdSlots.add(leaderboardCompanionAdSlot);
//	    }
//
//	    container.setCompanionSlots(companionAdSlots);
	    request.setAdDisplayContainer(container);
	    return request;
	  }
	
	protected void requestAd() {
		log(adTagUrl);
		adsLoader.requestAds(buildAdsRequest());
		
		//ivLoading.setVisibility(View.VISIBLE); // show loading image
		//frameAnimation.start(); // start animation for loading
	}
	
	//==================================================
	// Methods for calling web services and getting video stream urls
	//==================================================
	private void getAdEnabled() {
		/* Prepare Request Params for http post call */
		RequestParams params = new RequestParams();
		params.put("isads", _packageName);

		String url = "http://eboundservices.com/hash/ads.php";
		
		AsyncHttpClient client = new AsyncHttpClient(); // Use android AsyncHttp Client for http call
		client.post(this, url, params, new AsyncHttpResponseHandler() {
        	@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
				
				ivLoading.setVisibility(View.VISIBLE); // show loading image
				frameAnimation.start(); // start animation for loading
			}
			@Override
            public void onSuccess(String response) {
				//System.out.println(response);	
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();

				if (response.toLowerCase().equals("no")) {
					getVideoUrlFormat(); // get video url format 
				} else {
					getAdTag(); // get TagUrl			
				}
            }
			@Override
			public void onFailure(Throwable error, String content)
			{
				Toast.makeText(HashVideoActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				closeAll();
			}
        });
	}
	
	private void getAdTag() {
		String url = "http://eboundservices.com/hash/videoads.php?stream="+ stream;
		
		AsyncHttpClient client = new AsyncHttpClient(); // Use android AsyncHttp Client for http call
		client.get(url, new AsyncHttpResponseHandler() {
        	@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
				
				ivLoading.setVisibility(View.VISIBLE); // show loading image
				frameAnimation.start(); // start animation for loading
			}
			@Override
            public void onSuccess(String response) {
				//System.out.println(response);	
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				
				adTagUrl = response.trim().replace("<xml><adv>", "");
				adTagUrl = adTagUrl.trim().replace("</adv></xml>", "");
		
				requestAd(); // request ima ads				
            }
			@Override
			public void onFailure(Throwable error, String content)
			{
				Toast.makeText(HashVideoActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				closeAll();
			}
        });
	}
	
	private void getVideoUrlFormat() {
		String url = null;
		if (type == 0) {
			closeAll();
			return;
		} else if (type == STREAM_TYPE) { // if stream video is requested
			url = "http://eboundservices.com/hash/live.php";
		} else if (type == VOD_TYPE) { // if vod video is requested
			url = "http://eboundservices.com/hash/vod.php";
		}
		
		AsyncHttpClient client = new AsyncHttpClient(); // Use android AsyncHttp Client for http call
		client.setBasicAuth("admin", "mypass"); // Set basic authentication
		client.get(url, new AsyncHttpResponseHandler() { // Run http get request
        	@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
				ivLoading.setVisibility(View.VISIBLE); // show loading image
				frameAnimation.start(); // start animation for loading
			}
			@Override
            public void onSuccess(String response) {
				//System.out.println(response);
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();

				if (type == STREAM_TYPE) { // if stream video is requested
					streamUrl = response.trim().replace("{streamname}", stream);
				} else if (type == VOD_TYPE) { // if vod video is requested
					streamUrl = response.trim().replace("{filename}", stream).replace("{date}", date);					
				} 
				getHashedUrl(); // get hashed url
				
            }
			@Override
			public void onFailure(Throwable error, String content)
			{
				Toast.makeText(HashVideoActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				closeAll();
			}
        });
	}
	
	
	private void getHashedUrl() {
		String url = "http://eboundservices.com/hash/";
		
		AsyncHttpClient client = new AsyncHttpClient(); // Use android AsyncHttp Client for http call
		client.setBasicAuth("admin", "mypass"); // Set basic authentication
		client.get(url, new AsyncHttpResponseHandler() { // Run http get request
        	@Override
			public void onStart() {
				// TODO Auto-generated method stub
				super.onStart();
				ivLoading.setVisibility(View.VISIBLE); // show loading image
				frameAnimation.start(); // start animation for loading
			}
			@Override
            public void onSuccess(String response) {
				//System.out.println(response);				
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				
				if (streamUrl != null  ||  streamUrl.length() > 0) {
					streamUrl = streamUrl.replace("{hash}", response.trim()); // append hash code to video stream url
					playVideo(streamUrl);
				}
            }
			@Override
			public void onFailure(Throwable error, String content)
			{
				Toast.makeText(HashVideoActivity.this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
				ivLoading.setVisibility(View.INVISIBLE);
				frameAnimation.stop();
				closeAll();
			}
        });				
	}
		
	protected void playVideo(String videoUrl) {
	    log("playVideo: "+ videoUrl);
	    videoPlayer.playContent(videoUrl);
	    
	    contentStarted = true;
	}
	
	//==================================================
	// Methods for feedback dialog
	//==================================================
	private void showFeedbackDialog(){
		if (feedbackDlg == null) {
			/* Get Email address from account of device */		
			
			feedbackDlg = new Dialog(this);
			feedbackDlg.requestWindowFeature(Window.FEATURE_NO_TITLE);			
			//_feedbackDlg.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
			feedbackDlg.setCancelable(false);
			//_feedbackDlg.setTitle("FEEDBACK");
			
			final float scale = this.getResources().getDisplayMetrics().density;
			Display display = getWindowManager().getDefaultDisplay();
	    	Point size = new Point();
	    	int width;
	    	if (android.os.Build.VERSION.SDK_INT >= 13) {
	        	display.getSize(size);
	        	width = size.x>size.y ? size.x : size.y;
	    	} else {
	        	width = display.getWidth()>display.getHeight() ? display.getWidth() : display.getHeight();
	    	}
	    	// check if device is tablet or smartphone
	    	if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE) {
	    		width = (int) (width / 2);
	    	} else { // in case of smartphone
		    	width = (int) (width *2/3);
	    	}
	    			
			// Creating a new RelativeLayout
			LinearLayout dlgLayout = new LinearLayout(this);
			// Defining the RelativeLayout layout parameters.
			LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);		
			dlgLayout.setGravity(Gravity.CENTER_HORIZONTAL);
			dlgLayout.setOrientation(LinearLayout.VERTICAL);
			dlgLayout.setPadding((int)(10*scale), (int)(10*scale), (int)(10*scale), (int)(10*scale));
			
			// Creating a new RelativeLayout for title, send and cancel button
			RelativeLayout rlContainer = new RelativeLayout(this);
			LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);			
			rlContainer.setLayoutParams(lparams);
			
			Button btCancel = new Button(this);		
			RelativeLayout.LayoutParams rparams = new RelativeLayout.LayoutParams((int)(100*scale), (int)(50*scale));
			rparams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
			rparams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
			btCancel.setLayoutParams(rparams);
			btCancel.setId(2);
			btCancel.setText("CANCEL");
			btCancel.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					feedbackDlg.dismiss();

					// hide keyboard
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
					
					if ( exception ) closeAll(); // if exception was happened, finish activity
				}				
			});
			rlContainer.addView(btCancel);
			
			TextView tvTitle = new TextView(this);
			rparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
			rparams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
			rparams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
			tvTitle.setText("FEEDBACK");
			tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, btCancel.getTextSize());
			tvTitle.setTextColor(Color.MAGENTA);
			tvTitle.setLayoutParams(rparams);
			rlContainer.addView(tvTitle);			
			
			Button btSend = new Button(this);		
			rparams = new RelativeLayout.LayoutParams((int)(100*scale), (int)(50*scale));
			rparams.addRule(RelativeLayout.LEFT_OF, btCancel.getId());
			rparams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
			rparams.setMargins(0, 0, (int)(30*scale), 0); 
			btSend.setLayoutParams(rparams);
			btSend.setText("SEND");
			btSend.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					sendFeedback();
				}				
			});
			rlContainer.addView(btSend);
			dlgLayout.addView(rlContainer);
				
			// Creating a new LinearLayout for email
			LinearLayout llContainer = new LinearLayout(this);
			lparams = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);		
			lparams.gravity = Gravity.CENTER_HORIZONTAL;
			llContainer.setLayoutParams(lparams);
			
			TextView tvEmail = new TextView(this);
			lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			lparams.setMargins(0, 0, (int)(20*scale), 0);
			tvEmail.setLayoutParams(lparams);
			tvEmail.setText("Email Address");
			llContainer.addView(tvEmail);	
			
			etEmail = new EditText(this);
			lparams = new LinearLayout.LayoutParams((int)(width * 2/3), LinearLayout.LayoutParams.WRAP_CONTENT);
			etEmail.setText(GetEmailAddress());
			etEmail.setLayoutParams(lparams);
			llContainer.addView(etEmail);				
			dlgLayout.addView(llContainer);
			
			etFeedback = new EditText(this);
			lparams = new LinearLayout.LayoutParams(width, LayoutParams.WRAP_CONTENT);
			lparams.setMargins(0, (int)(10*scale), 0, (int)(30*scale));
			etFeedback.setLayoutParams(lparams);
			etFeedback.setHint("Please enter your feedback here");
			etFeedback.setLines(5);
			dlgLayout.addView(etFeedback);
			
			feedbackDlg.setContentView(dlgLayout, llp);
		} else {
			etFeedback.setText("");
		}
		feedbackDlg.show();
	}
	
	private String GetEmailAddress() { // Get Email Address from account in device
		String email = "";
		Pattern emailPattern = Patterns.EMAIL_ADDRESS;
		Account[] accounts = AccountManager.get(this).getAccounts();
		for (Account account : accounts) {
			if (emailPattern.matcher(account.name).matches()) {
				email = account.name; break; 	
			}
		}
		
		return email;
	}
	
	private void sendFeedback() {
		String feedbackMsg = etFeedback.getText().toString();
		String email = etEmail.getText().toString();
		if (email.length() == 0) {
			Toast.makeText(HashVideoActivity.this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
			return;
		} 
		
		if (feedbackMsg.length() == 0) {
			Toast.makeText(HashVideoActivity.this, "Please enter your feedback.", Toast.LENGTH_SHORT).show();
			return;
		}
			
		feedbackDlg.dismiss();
		String url = "http://eboundservices.com/hash/feedback/?email="+ email +"&feedback="+ feedbackMsg +"&platform=android";
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(this, url, new AsyncHttpResponseHandler() {
			@Override
            public void onSuccess(String response) {
				//System.out.println(response);				
				Toast.makeText(getApplicationContext(), "Message has been sent successfully", Toast.LENGTH_SHORT).show();
            }
			@Override
			public void onFailure(Throwable error, String content)
			{
                Toast.makeText(getApplicationContext(), "Message sending failure", Toast.LENGTH_SHORT).show();
			}
        });
		
		if ( exception ) closeAll();
	}
	
	private void log(String msg) {
		Log.d(TAG, msg);
	}
}
