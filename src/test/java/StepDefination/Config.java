package StepDefination;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Settings from src/test/resources/config.properties. Any key can be overridden for one
 * run with a JVM property of the same name, e.g. mvn test -Dbrowser=firefox -Dheadless=true
 */
public final class Config {

	// Loaded once, when a step first asks for a value
	private static final Properties PROPS = load();

	private Config() {
	}

	private static Properties load() {
		Properties props = new Properties();
		// Read from the test classpath, so it works from Maven and from the IDE
		try (InputStream in = Config.class.getResourceAsStream("/config.properties")) {
			if (in == null) {
				throw new IllegalStateException("config.properties not found on the test classpath");
			}
			props.load(in);
		} catch (IOException e) {
			throw new IllegalStateException("Cannot read config.properties", e);
		}
		// A -D value with the same key wins over the file
		for (String key : props.stringPropertyNames()) {
			String override = System.getProperty(key);
			if (override != null && !override.isEmpty()) {
				props.setProperty(key, override);
			}
		}
		return props;
	}

	/**
	 * @param key a key of config.properties
	 * @return String its value (trimmed)
	 * @throws IllegalArgumentException when the key is missing, so a typo fails clearly
	 */
	public static String get(String key) {
		String value = PROPS.getProperty(key);
		if (value == null) {
			throw new IllegalArgumentException("No '" + key + "' in config.properties");
		}
		return value.trim();
	}
}
