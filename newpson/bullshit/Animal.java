package newpson.bullshit;

interface Playable
{
	default public void play()
	{
		System.out.println("Unknown sound");
	}
}

interface Feasible
{
	default public void perform()
	{
		System.out.println("Unknown action");
	}
}

class Meow implements Playable
{
	@Override
	public void play()
	{
		System.out.println("(^O.-^) meow...");
	}
}

class Violin implements Playable
{
	@Override
	public void play()
	{
		System.out.println("Playing violin...");
	}
}

class Dance implements Feasible
{
	@Override
	public void perform()
	{
		System.out.println("Dancing...");
	}
}

class Burnout implements Feasible
{
	@Override
	public void perform()
	{
		System.out.println("Now I can't do anything, even sleep...");
	}
}

public class Animal
{
	@AutoInjectable
	private Playable sound;

	@AutoInjectable
	private Feasible action;

	public void declare()
	{
		sound.play();
		action.perform();
	}
}
