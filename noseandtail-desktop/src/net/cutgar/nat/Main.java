package net.cutgar.nat;

import org.flixel.FlxDesktopApplication;

import com.badlogic.gdx.tools.imagepacker.TexturePacker;
import com.badlogic.gdx.tools.imagepacker.TexturePacker.Settings;

public class Main
 {
	public static void main(String[] args) 
	{
		Settings settings = new Settings();
        settings.padding = 2;
        settings.maxWidth = 512;
        settings.maxHeight = 512;
        settings.incremental = true;
        TexturePacker.process(settings, "../noseandtail-android/images", "../noseandtail-android/assets");
		
		new FlxDesktopApplication(new NoseAndTail(), 800, 480);
	}
}
