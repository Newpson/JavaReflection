package newpson.bullshit;

import java.io.InputStream;
import java.io.IOException;
import java.lang.IllegalAccessException;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Injector
{
	static Properties props;
	static
	{
		props = new Properties();
		try
		{
			InputStream input = Injector.class.getClassLoader().getResourceAsStream("res/Injector.properties");
			props.load(input);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static <T> T inject(T target)
	{
		List<Field> allFields = Arrays.asList(target.getClass().getDeclaredFields());

		for (Field f: allFields)
			if (f.isAnnotationPresent(AutoInjectable.class))
			{
				f.setAccessible(true);
				try
				{
					if (f.getType() == Playable.class)
						f.set(target, Class.forName(
							props.getProperty("newpson.bullshit.Playable")
						).newInstance());
					else if (f.getType() == Feasible.class)
						f.set(target, Class.forName(
							props.getProperty("newpson.bullshit.Feasible")
						).newInstance());
				}
				catch (IllegalAccessException | ClassNotFoundException | InstantiationException e)
				{
					e.printStackTrace();
				}
			}
		return target;
	}
}
