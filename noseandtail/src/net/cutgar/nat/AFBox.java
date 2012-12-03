package net.cutgar.nat;

import org.flixel.FlxSprite;
import org.flixel.FlxTimer;

public class AFBox extends FlxSprite {
	
	public boolean isUsed = false;
	public boolean willTurnIntoTail = false;
	public int TAIL_COLOUR = 0xff9e935d;
	public int NOSE_COLOUR = 0xff9e61ee;
	protected FlxTimer switchCostumeTimer;
	
	public AFBox(int x, int y){
		super(x * Registry.TS, y*Registry.TS);
		loadGraphic("pack:box-strip", true, true, 16, 32);
		addAnimation("tail", new int[]{0});
		addAnimation("nose", new int[]{1});
		addAnimation("tail-used", new int[]{3});
		addAnimation("nose-used", new int[]{4});
		play("nose");
		immovable = true;
		
	}
	
	public AFBox(int x, int y, boolean tail){
		super(x * Registry.TS, y*Registry.TS);
		loadGraphic("pack:box-strip", true, true, 16, 32);
		addAnimation("tail", new int[]{0});
		addAnimation("nose", new int[]{1});
		addAnimation("tail-used", new int[]{3});
		addAnimation("nose-used", new int[]{4});
		if(tail)
			play("tail");
		else
			play("nose");
		
		willTurnIntoTail = tail;
		immovable = true;
	}

	public void used(){
		isUsed = true;
		if(willTurnIntoTail)
			play("tail-used");
		else
			play("nose-used");
	}
	
	@Override
	public void update(){
		super.update();
		if(switchCostumeTimer != null)
			switchCostumeTimer.update();
	}

}
