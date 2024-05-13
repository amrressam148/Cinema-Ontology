package pack;
import tools.JenaEngine;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
public class Task6 {
	
	private Model model;
	private String file;

	Task6(String path) {
		this.file = path;
		this.model = JenaEngine.readModel(file);

		//this.model = JenaEngine.readInferencedModelFromRuleFile(model,
			//	"data/owlrules.txt");
		this.model = JenaEngine.readInferencedModelFromRuleFile(model,
				"Ontology/rules6.txt");
	}

	public void readPersonAge() {
		String query = "PREFIX : <http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person ?age "
				+ "WHERE{"
				+ "?person rdf:type :PersonAge. ?person :age ?age." + "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

	public void readActorMale() {
		String query = "PREFIX : <http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?person ?gender "
				+ "WHERE{"
				+ "?person rdf:type :ActorMale. ?person :hasGenderType ?gender."
				+ "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}

	public void readEnglishMovie() {
		String query = "PREFIX : <http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/>"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
				+ "SELECT ?movie ?year ?language "
				+ "WHERE{"
				+ "?movie rdf:type :EnglishMovie. ?movie :year ?year.  ?movie :language ?language ."
				+ "}";
		System.out.println(JenaEngine.executeQuery(model, query));
	}
	

}
