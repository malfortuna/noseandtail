package net.cutgar.nat.juice;

import org.flixel.FlxObject;

public class TweenBounce extends TweenTarget {

	float spill;
	float nextSpill;
	boolean pos;
	float tolerance = 1f;
	
	public TweenBounce(FlxObject b, float target, float overSpillProportion){
		super(b, target);
		this.spill = overSpillProportion;
		float abs = target - b.y;
		if(abs > 0){ //basic is above target
			nextSpill = target + (abs * spill);
		}
		else
			nextSpill = target + 2 * (abs * spill);
		pos = abs > 0;
	}
	
	@Override
	public void doTween(){
		basic.y += 0.2 * (nextSpill - basic.y);
		if(Math.abs(nextSpill - basic.y) < tolerance){
			float abs = target - basic.y;
			if(abs > 0){ //basic is above target
				nextSpill = target + (abs * spill);
			}
			else
				nextSpill = target + 2 * (abs * spill);
		}
	}

}
