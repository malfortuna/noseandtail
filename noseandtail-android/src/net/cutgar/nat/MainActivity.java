package net.cutgar.nat;

import org.flixel.FlxAndroidApplication;

public class MainActivity extends FlxAndroidApplication 
{
    public MainActivity()
	{
		super(new NoseAndTail());
	}
}