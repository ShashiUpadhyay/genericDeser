package genericDeser.util;

public enum genericDeserTokens {

	SET("set"), 
	FQN("fqn"), 
	TYPE("type"), 
	VAR("var"), 
	VALUE("value"), 
	COLON(":"), 
	DOT("."), 
	COMMA(","), 
	EQUAL("="),
	INT("int"),
	SHORT("short"),
	FLOAT("float"),
	LONG("long"),
	DOUBLE("double"),
	BOOLEAN("boolean"),
	STRING("String");

	private String prefix;

	private genericDeserTokens(String prefixIn) {
		prefix = prefixIn;
	}

	public String getValue() {
		return prefix;
	}

}
