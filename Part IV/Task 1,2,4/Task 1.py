import rdflib
from rdflib.namespace import OWL, RDF, RDFS
from SPARQLWrapper import SPARQLWrapper, JSON
from rdflib import Graph, Namespace, URIRef

# Load the ontology
g = Graph()
g.parse(r"C:\Users\Dell\Desktop\Cinema.rdf")

# Define the URIs for the subclasses
director_uri = URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/Director")
writer_uri = URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/Writer")
actor_uri = URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/Actor")

# Find individuals that are instances of Director, Writer, or Actor
persons = set()
for s, p, o in g.triples((None, RDF.type, None)):
    if o in [director_uri, writer_uri, actor_uri]:
        persons.add(s)

# Print the results
for person in persons:
    print(person)