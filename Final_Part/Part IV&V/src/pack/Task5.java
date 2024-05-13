package pack;
import tools.JenaEngine;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
public class Task5 {
	
	private Model model;
	private String file;
	private String namespace;
	 
	Task5(String path){
		this.namespace = "";
		this.file = path;
		this.model = JenaEngine.readModel(path);
		if(model != null ){
			namespace = model.getNsPrefixURI("");
		}
	}
	
	public void readActorDirector(){
		//this.model = JenaEngine.readInferencedModelFromRuleFile(model, "Ontology/owlrules.txt");
		this.model = JenaEngine.readInferencedModelFromRuleFile(model, "Ontology/rule5.txt");
		
		String query = "PREFIX : <http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person  "
				+ "WHERE{"
				+ "?person rdf:type :ActorDirector. " + "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

	

}
