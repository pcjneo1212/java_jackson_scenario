//Code generated according to input schema and output schema
//Code generated according to input schema and output schema

System.out.println("**jsonpayload***"+globalMap.get("jsonpayload"));
StringBuilder sb = new StringBuilder(0);


List<String> rowDimensions = Arrays.asList("Account", "Operation Type", "Material Type", "Entity", "Customer", "Years", "Scenario", "Version", "Plan Element");
List<String> povDimensions = Arrays.asList("Currency");


String commaSeparatedNames = rowDimensions.stream().collect(Collectors.joining(","));
commaSeparatedNames = commaSeparatedNames+","+povDimensions.stream().collect(Collectors.joining(","));

System.out.println("**rowDimensions***"+commaSeparatedNames);

ObjectMapper objectMapper = new ObjectMapper();
JsonNode jsonNode = objectMapper.readTree((String)globalMap.get("jsonpayload"));
JsonNode studentsArray = jsonNode.get("columns");
List<String> collist = new ArrayList<String>();
for (JsonNode student : studentsArray) {

	collist.add(student.toString());
}
System.out.println(collist.stream().collect(Collectors.joining(",")));
commaSeparatedNames = commaSeparatedNames+","+collist.stream().collect(Collectors.joining(","));
sb.append(commaSeparatedNames);
sb.append(System.lineSeparator());


JsonNode rowsarrray = jsonNode.get("rows");

String headernames="";
String datanames="";

for (JsonNode student : rowsarrray) {
	List<String> headers = new ArrayList<String>();
	List<String> dataList = new ArrayList<String>();

	JsonNode js = objectMapper.readTree(student.toString());
	JsonNode hea = js.get("headers");	
	for (JsonNode head : hea) {
		headers.add(head.toString());

	}
	JsonNode datal = js.get("data");	
	for (JsonNode head : datal) {
		dataList.add(head.toString());

	}
	headernames = headers.stream().collect(Collectors.joining(","));
	datanames = dataList.stream().collect(Collectors.joining(","));
	sb.append(headernames);
	sb.append(",");
	JsonNode povarray = jsonNode.get("pov");
	for (JsonNode pv : povarray) {
		List<String> pov = new ArrayList<String>();
		sb.append(pv.toString());
		sb.append(",");
	}
	sb.append(datanames);
	sb.append(System.lineSeparator());

}
output_row.string = sb.toString().replaceAll("\\[", "").replaceAll("\\]", "");

