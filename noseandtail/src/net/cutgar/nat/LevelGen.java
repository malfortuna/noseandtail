package net.cutgar.nat;

import java.util.LinkedList;

import net.cutgar.nat.juice.TweenArrive;
import net.cutgar.nat.juice.TweenTarget;

import org.flixel.FlxG;
import org.flixel.FlxGroup;
import org.flixel.FlxText;
import org.flixel.FlxTileblock;
import org.flixel.FlxTilemap;

public class LevelGen {
	
	
	public static int PURPLE_BRIGHT = 0xff9E469C;
	public static int FISH_BASE = 0xff9E935D;

	public static void GenLevel(PlayState s, int level){
		s.tweens = new LinkedList<TweenTarget>();
		s.blocks = new FlxGroup();
		s.boxes = new FlxGroup();
		s.bottles = new FlxGroup();
		
		if(level == 0){
			FlxText title = new FlxText(0, 0, FlxG.width);
			title.setText("NOSE & TAIL: COSTUMED CRUSADER");
			title.setFormat(title.getFont(), 16, PURPLE_BRIGHT, "left");
			s.add(title);
			
			FlxText subtitle = new FlxText(0, 16, FlxG.width);
			subtitle.setText("Being the tale of an action figure leading a double life");
			subtitle.setFormat(subtitle.getFont(), 8, PURPLE_BRIGHT, "left");
			s.add(subtitle);
			
			FlxTileblock floor = new FlxTileblock(0, FlxG.height - 16, FlxG.width, 16);
			floor.makeGraphic(FlxG.width, 16, PURPLE_BRIGHT);
			s.blocks.add(floor);
			floor = new FlxTileblock(0, 32, 16, FlxG.height-32);
			floor.makeGraphic(16, FlxG.height-32, PURPLE_BRIGHT);
			s.blocks.add(floor);
			floor = new FlxTileblock(FlxG.width-16, 32, 16, FlxG.height-32);
			floor.makeGraphic(16, FlxG.height-32, PURPLE_BRIGHT);
			s.blocks.add(floor);

			s.boxes.add(new AFBox(10, 12, true));
			
			FlxText tweenIn = new FlxText(FlxG.width+10, 11*Registry.TS, FlxG.width);
			tweenIn.setText("Press 'UP' at a box to swap costume");
			tweenIn.setFormat(tweenIn.getFont(), 8, PURPLE_BRIGHT, "left");
			s.add(tweenIn);
			s.tweens.add(new TweenArrive(tweenIn, 7*Registry.TS, 0.03f, false));
			tweenIn = new FlxText(FlxG.width*2, 12*Registry.TS, FlxG.width);
			tweenIn.setText("Get to the exit in the right costume.");
			tweenIn.setFormat(tweenIn.getFont(), 8, FISH_BASE, "left");
			s.add(tweenIn);
			s.tweens.add(new TweenArrive(tweenIn, 12*Registry.TS, 0.03f, false));
			
			s.add(s.blocks);
			s.add(s.boxes);
			
			s.add(Registry.player = new Player(3, 3));
			s.add(Registry.exit = new Exit(16, 13, true));
			return;
		}
		else if(level == 1){
			FlxText title = new FlxText(0, 0, FlxG.width);
			title.setText("A BEACHED TAIL");
			title.setFormat(title.getFont(), 16, FISH_BASE, "left");
			s.add(title);
			
			FlxText subtitle = new FlxText(0, 16, FlxG.width);
			subtitle.setText("Nose's costume is heavy, so you can't jump as high.");
			subtitle.setFormat(subtitle.getFont(), 8, FISH_BASE, "left");
			s.add(subtitle);
			
			s.tiles = new FlxTilemap();
			s.tiles.loadMap(
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1\n" +
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"
					, "pack:tiles");
			s.add(s.tiles);

			s.boxes.add(new AFBox(19,10, true));
			s.add(s.boxes);
			
			s.add(Registry.player = new Player(3, 3));
			s.add(Registry.exit = new Exit(18, 4, true));
			return;
		}
		else if(level == 2){
			FlxText title = new FlxText(0, 0, FlxG.width);
			title.setText("TOOTH AND TAIL");
			title.setFormat(title.getFont(), 16, FISH_BASE, "left");
			s.add(title);
			
			FlxText subtitle = new FlxText(0, 16, FlxG.width);
			subtitle.setText("Only Nose can collect the bottles!");
			subtitle.setFormat(subtitle.getFont(), 8, FISH_BASE, "left");
			s.add(subtitle);
			
			s.tiles = new FlxTilemap();
			s.tiles.loadMap(
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1\n" +
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1\n" +
					"1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"
					, "pack:tiles");
			s.add(s.tiles);
			
			FlxText tweenIn = new FlxText(FlxG.width+10, 8*Registry.TS, FlxG.width);
			tweenIn.setText("You need all the bottles to exit.");
			tweenIn.setFormat(tweenIn.getFont(), 8, FISH_BASE, "left");
			s.add(tweenIn);
			s.tweens.add(new TweenArrive(tweenIn, 5*Registry.TS, 0.04f, false));
			
			s.bottles.add(new Bottle(10, 7));
			s.bottles.add(new Bottle(11, 7));
			s.bottles.add(new Bottle(12, 7));
			
			s.bottles.add(new Bottle(19, 4));
			s.bottles.add(new Bottle(20, 4));
			s.add(s.bottles);

			s.boxes.add(new AFBox(21,3, false));
			s.boxes.add(new AFBox(21,10, true));
			s.add(s.boxes);
			
			s.add(Registry.player = new Player(3, 10));
			s.add(Registry.exit = new Exit(8, 7, false));
			return;
		}
		else if(level == 3){
			FlxText title = new FlxText(0, 0, FlxG.width);
			title.setText("TAIL NOSE BEST");
			title.setFormat(title.getFont(), 16, FISH_BASE, "left");
			s.add(title);
			
			FlxText subtitle = new FlxText(0, 16, FlxG.width);
			subtitle.setText("You can only use a costume box once...");
			subtitle.setFormat(subtitle.getFont(), 8, FISH_BASE, "left");
			s.add(subtitle);
			
			s.tiles = new FlxTilemap();
			s.tiles.loadMap(
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1\n" +
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"
					, "pack:tiles");
			s.add(s.tiles);
			
			FlxText restart = new FlxText(15*Registry.TS, 13*Registry.TS, FlxG.width);
			restart.setFormat(restart.getFont(), 8, FISH_BASE, "left");
			restart.setText("Press R to restart");
			s.add(restart);
			
			s.bottles.add(new Bottle(5, 7));
			s.bottles.add(new Bottle(6, 7));
			s.bottles.add(new Bottle(7, 7));
			
			s.bottles.add(new Bottle(11, 7));
			s.bottles.add(new Bottle(12, 7));
			s.bottles.add(new Bottle(13, 7));
			s.bottles.add(new Bottle(14, 7));
			s.bottles.add(new Bottle(13, 4));
			s.bottles.add(new Bottle(14, 4));
			s.bottles.add(new Bottle(15, 4));
			s.add(s.bottles);

			s.boxes.add(new AFBox(8,6, false));
			s.boxes.add(new AFBox(21,10, true));
			s.add(s.boxes);
			
			s.add(Registry.player = new Player(21, 4));
			s.add(Registry.exit = new Exit(10, 13, false));
			return;
		}
		else if(level == 4){
			FlxText title = new FlxText(0, 0, FlxG.width);
			title.setText("TAIL AND ERROR");
			title.setFormat(title.getFont(), 16, FISH_BASE, "left");
			s.add(title);
			
			FlxText subtitle = new FlxText(0, 16, FlxG.width);
			subtitle.setText("Press R to restart");
			subtitle.setFormat(subtitle.getFont(), 8, FISH_BASE, "left");
			s.add(subtitle);
			
			s.tiles = new FlxTilemap();
			s.tiles.loadMap(
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1\n" +
					"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1\n" +
					"1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1"
					, "pack:tiles");
			s.add(s.tiles);
			
			s.bottles.add(new Bottle(4, 4));
			s.bottles.add(new Bottle(5, 4));
			s.bottles.add(new Bottle(6, 4));
			s.bottles.add(new Bottle(11, 4));
			s.bottles.add(new Bottle(12, 4));
			s.bottles.add(new Bottle(13, 4));
			s.bottles.add(new Bottle(14, 4));
			s.bottles.add(new Bottle(21, 4));
			s.bottles.add(new Bottle(22, 4));
			
			s.bottles.add(new Bottle(6, 7));
			s.bottles.add(new Bottle(7, 7));
			s.bottles.add(new Bottle(8, 7));
			
			s.bottles.add(new Bottle(15, 11));
			s.bottles.add(new Bottle(16, 11));
			s.bottles.add(new Bottle(17, 11));
			s.bottles.add(new Bottle(13, 4));
			s.bottles.add(new Bottle(14, 4));
			s.bottles.add(new Bottle(15, 4));
			s.add(s.bottles);

			s.boxes.add(new AFBox(9,6, false));
			s.boxes.add(new AFBox(21,10, true));
			s.add(s.boxes);
			
			s.add(Registry.player = new Player(2, 4));
			s.add(Registry.exit = new Exit(2, 13, false));
			return;
		}
	}
	
}
