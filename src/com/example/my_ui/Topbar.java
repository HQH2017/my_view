package com.example.my_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout{

	private Button leftButton,rightButton;
	private TextView tvTitle;
	
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;
	
	private float titleTextSize;
	private int titleTextColor;
	private String title;
	
	private LayoutParams leftParams,rightParams,titleParams;
	
	//接口回调，向外提供接口点击
	public TopbarClickListener tlistener;
	public interface TopbarClickListener{
		public void leftClick();
		public void rightClick();
	}
	public void setTopbarClickListener(TopbarClickListener tlistener){
		this.tlistener=tlistener;
	}
	
	
	public Topbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		//通过TypedArray 来存取从xml 获取到的值
		TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.Topbar);
		
		leftTextColor=ta.getColor(R.styleable.Topbar_leftTitleColor, 0);
		leftBackground=ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText=ta.getString(R.styleable.Topbar_leftTitle);
		
		rightTextColor=ta.getColor(R.styleable.Topbar_leftTitleColor, 0);
		rightBackground=ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText=ta.getString(R.styleable.Topbar_rightTitle);
		
		titleTextSize=ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor=ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		title=ta.getString(R.styleable.Topbar_title);
		
		ta.recycle();
		
		leftButton=new Button(context);
		rightButton=new Button(context);
		tvTitle=new TextView(context);
		
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);
		
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);
		
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setTextSize(titleTextSize);
		tvTitle.setText(title);
		tvTitle.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFF59563);
		
		leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
	    addView(leftButton,leftParams);
	
	    rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
	    addView(rightButton,rightParams);
	
	    titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
	    titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
	    addView(tvTitle,titleParams);
	  
	    leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(tlistener!=null){
					tlistener.leftClick();
				}
			}
		});
       rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(tlistener!=null){
					tlistener.rightClick();
				}
			}
		});
	}

}
