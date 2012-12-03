package net.cutgar.nat;

import org.flixel.FlxG;
import org.flixel.FlxObject;
import org.flixel.FlxSprite;

public class Player extends FlxSprite {

	public boolean isTail = false;
	public int TAIL_COLOUR = 0xff9e935d;
	public int NOSE_COLOUR = 0xff9e61ee;
	
	public Player(int x, int y){
		super(x*Registry.TS, y*Registry.TS);
		loadGraphic("pack:player-strip", true, true, 16);
		addAnimation("idle", new int[]{0,2}, 2, true);
		addAnimation("walk", new int[]{0,1,2,3}, 8, true);
		addAnimation("jump", new int[]{4}, 1, true);
		addAnimation("idle-tail", new int[]{5});
		addAnimation("walk-tail", new int[]{5,6,7}, 8, true);
		addAnimation("jump-tail", new int[]{8});
		
		play("idle");
		acceleration.y = 400;
	}
	
	@Override
	public void update(){
		
		if(FlxG.keys.LEFT){
			velocity.x = -100;
			setFacing(FlxObject.LEFT);
		}
		else if(FlxG.keys.RIGHT){
			velocity.x = 100;
			setFacing(FlxObject.RIGHT);
		}
		else{
			velocity.x = 0;
		}
		
		if(FlxG.keys.SPACE && isTouching(FlxObject.FLOOR)){
			if(!isTail)
				velocity.y = -150;
			else
				velocity.y = -250;
		}
		
		if(FlxG.keys.X){
//			play("attack");
//			attacking = true;
		}
		else{
//			attacking = false;
			
			if(velocity.y != 0){
				if(isTail)
					play("jump-tail");
				else
					play("jump");
			}
			else if(velocity.x != 0){
				if(isTail)
					play("walk-tail");
				else
					play("walk");
			}
			else{
				if(isTail)
					play("idle-tail");
				else
					play("idle");
			}
		
		}
		
	}

	public void switchCostume(){
		isTail = !isTail;
	}
}
