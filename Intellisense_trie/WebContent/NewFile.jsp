<%@ page import="java.util.List"%>
<%@ page import="Demo.Tries"%>
<%@ page import="Demo.LoadData"%>
<%@ page import="Demo.TestTries" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<%
	String data1 = request.getParameter("sg");
	Tries trie = new Tries();
	LoadData dataload = new LoadData();
	trie = dataload.load(trie);
	TestTries obj = new TestTries();
	List<String> list = obj.getList(data1,trie);
//	JSONObject json = new JSONObject();
	Iterator<String> iterator = list.iterator();
	//json.put("countries", "Azeem");
	//json.put("countries", "Abdul");
  	 while (iterator.hasNext()) {    
    	//json.put("countries", iterator.next());
    	out.println(iterator.next());
 	}
//    out.print(json.toString());
%>