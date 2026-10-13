package StepDefination;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {

	private static final Properties PROPS = load();

	private Config() {
	}

	private static Properties load() {
		Properties props = new Properties();
		try (InputStream in = Config.class.getResourceAsStream("/config.properties")) {
			if (in == null) {
				throw new IllegalStateException("config.properties not found on the test classpath");
			}
			props.load(in);
		} catch (IOException e) {
			throw new IllegalStateException("Cannot read config.properties", e);
		}
		for (String key : props.stringPropertyNames()) {
			String override = System.getProperty(key);
			if (override != null && !override.isEmpty()) {
				props.setProperty(key, override);
			}
		}
		return props;
	}

	public static String get(String key) {
		String value = PROPS.getProperty(key);
		if (value == null) {
			throw new IllegalArgumentException("No '" + key + "' in config.properties");
		}
		return value.trim();
	}
}
