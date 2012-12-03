package net.cutgar.nat;

import org.flixel.FlxSprite;

public class Bottle extends FlxSprite {
	
	public Bottle(int x, int y){
		super(x*Registry.TS, y*Registry.TS);
		loadGraphic("pack:bottle", true, false, 16, 16);
		addAnimation("float", new int[]{0,1,2,3}, 8, true);
		play("float");
	}

}
