package newpson.bullshit;

public class Demo
{
	public static void main(String[] args) throws Exception
	{
		Animal monster = Injector.inject(new Animal());
		monster.declare();
	}
}
