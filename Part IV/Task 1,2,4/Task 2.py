from rdflib import Graph

# Load the ontology
g = Graph()
g.parse(r"C:\Users\Dell\Desktop\Cinema.rdf")

# Load the SPARQL query
with open(r"C:\Users\Dell\Desktop\Ontology Project\query.rq", "r") as f:
    query_string = f.read()

# Execute the query
results = g.query(query_string)

# Use a set to store unique results
unique_results = set()

# Store the results in the set
for row in results:
    unique_results.add(row.person)

# Print the unique results
for person in unique_results:
    print(person)