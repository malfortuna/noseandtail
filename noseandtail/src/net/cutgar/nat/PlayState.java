package net.cutgar.nat;

import java.util.Iterator;
import java.util.List;

import net.cutgar.nat.juice.TweenTarget;

import org.flixel.FlxBasic;
import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxObject;
import org.flixel.FlxState;
import org.flixel.FlxText;
import org.flixel.FlxTilemap;
import org.flixel.FlxTimer;
import org.flixel.event.AFlxCamera;
import org.flixel.event.AFlxCollision;
import org.flixel.event.AFlxTimer;

public class PlayState extends FlxState {
	FlxGroup blocks;
	FlxGroup boxes;
	FlxGroup bottles;
	
	public int level;
	public List<TweenTarget> tweens;
	public FlxTilemap tiles;
	
	public PlayState(){
		super();
		this.level = 0;
	}
	
	public PlayState(int level){
		this.level = level;
	}

	@Override
	public void create(){
		FlxG.setBgColor(0xffBDAEB6);
		
		if(level % 2 == 0)
			FlxG.playMusic("nat1.mp3");
		else
			FlxG.playMusic("nat2.mp3");
		
		if(level < 5)
			LevelGen.GenLevel(this, level);
		else{
			FlxText over = new FlxText(0, FlxG.height/3, FlxG.width);
			over.setText("NOSE AND TAIL: COMPLETE");
			over.setFormat(over.getFont(), 16, LevelGen.PURPLE_BRIGHT, "center");
			add(over);
			
			over = new FlxText(0, 2*FlxG.height/3, FlxG.width);
			over.setText("Knocked together in about three hours for a four-word-game-jam.\nWords were: FISHERMAN/WINE_TASTER/ACTION_FIGURE/DISCOMBOBULATING\nThanks for playing! Let me know what you thought.\nhttp://www.cutgar.net and mike@cutgar.net");
			over.setFormat(over.getFont(), 8, LevelGen.PURPLE_BRIGHT, "center");
			add(over);
		}
	}

	@Override
	public void update(){
		super.update();
		
		if(level == 5){
			if(FlxG.keys.any())
				System.exit(0);
			return;
		}

		if(FlxG.keys.R){
			FlxG.switchState(new PlayState(level));
		}
		
		for(TweenTarget t : tweens){
			t.doTween();
		}
		
		if(blocks != null && blocks.length > 0){
			FlxG.collide(blocks, Registry.player);
			FlxG.collide(blocks, Registry.exit);
		}
		else{
			FlxG.collide(tiles, Registry.player);
			FlxG.collide(tiles, Registry.exit);
		}
		
		FlxG.overlap(Registry.player, bottles, new AFlxCollision(){

			@Override
			public void callback(FlxObject player_o, FlxObject bottle_o){
				Player p = (Player) player_o;
				Bottle b = (Bottle) bottle_o;
				if(!p.isTail){
					b.kill();
					//Play a sound effect
					if(Math.random() > 0.5)
						FlxG.play("pickup1.wav");
					else
						FlxG.play("pickup2.wav");
				}
			}
			
		});
		
		if(gotAllBottles()){
			FlxG.collide(Registry.exit, Registry.player, new AFlxCollision(){
				@Override
				public void callback(FlxObject exit_o, FlxObject player_o){
					Exit exit = (Exit) exit_o;
					Player player = (Player) player_o;
					if(exit.isTail == player.isTail){
						FlxG.fade(0xff000000, 1.0f, new AFlxCamera(){
							@Override
							public void callback(){
								FlxG.switchState(new PlayState(level+1));
							}
						});
					}
				}
			});
		}
		else{
			FlxG.collide(Registry.player, Registry.exit);
		}
		if(FlxG.keys.UP){
			FlxG.overlap(boxes, Registry.player, new AFlxCollision() {
				@Override
				public void callback(FlxObject box_o, FlxObject player_o){
					final AFBox box = (AFBox) box_o;
					final Player player = (Player) player_o;
					if (box.isUsed || box.willTurnIntoTail == player.isTail)
						return;

					Registry.player.kill();
					box.switchCostumeTimer = new FlxTimer();
					box.used();
					box.switchCostumeTimer.start(0.5f, 1, new AFlxTimer() {

						@Override
						public void callback(FlxTimer Timer){
							Registry.player.switchCostume();
							Registry.player.revive();
						}
					});
				}
			});
		}
	}

	private boolean gotAllBottles(){
		Iterator<FlxBasic> it = bottles.members.iterator();
		while(it.hasNext()){
			if(it.next().alive)
				return false;
		}
		return true;
	}
}