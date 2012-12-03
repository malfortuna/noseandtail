package net.cutgar.nat.juice;

import org.flixel.FlxObject;

public class TweenArrive extends TweenTarget {

	float speed;
	private boolean vertical;
	boolean done = false;
	float delta = 0.01f;
	
	public TweenArrive(FlxObject b, float target, float speed, boolean vertical){
		super(b, target);
		this.speed = speed;
		this.vertical = vertical;
	}
	
	@Override
	public void doTween(){
		if(done)
			return;
		if(vertical){
			basic.y += speed * (target - basic.y);
			if(Math.abs(target - basic.y) < delta){
				basic.y = target;
				done = true;
			}
		}
		else{
			basic.x += speed * (target - basic.x);
			if(Math.abs(target - basic.x) < delta){
				basic.x = target;
				done = true;
			}
		}
	}

}
