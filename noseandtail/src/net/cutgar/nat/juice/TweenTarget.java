package net.cutgar.nat.juice;

import org.flixel.FlxObject;

public class TweenTarget {

	protected FlxObject basic;
	protected float target;

	public TweenTarget(FlxObject b, float target){
		this.basic = b;
		this.target = target;
	}
	
	public void doTween(){};
	
	
	
}
