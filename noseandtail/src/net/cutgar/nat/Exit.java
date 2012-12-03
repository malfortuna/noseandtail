package net.cutgar.nat;

import org.flixel.FlxSprite;

public class Exit extends FlxSprite {

	boolean isTail;

	public Exit(int x, int y, boolean tailExit){
		super(x*Registry.TS, y*Registry.TS);
		this.isTail = tailExit;
		if(tailExit)
			loadGraphic("pack:exit-tail");
		else
			loadGraphic("pack:exit-nose");
		immovable = true;
	}
	
	
}
