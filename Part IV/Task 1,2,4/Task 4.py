from rdflib import Graph, URIRef
from rdflib.namespace import OWL, RDF, RDFS

def get_movie_info(movie_title):
    # Load the ontology
    g = Graph()
    g.parse(r"C:\Users\Dell\Desktop\Cinema.rdf")

    # Find the movie
    movie = URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/" + movie_title)
    if (movie, RDF.type, URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/Movie")) not in g:
        print("Movie not found!")
        return

    # Get movie details
    year = g.value(movie, URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/year"))
    country = g.value(movie, URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/country"))
    genres = g.objects(movie, URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/hasGenre"))
    actors = g.objects(movie, URIRef("http://www.semanticweb.org/msi/ontologies/2024/4/team8_project/hasActor"))

    # Print movie information
    print(f"Title: {movie_title}")
    print(f"Year: {year}")
    print(f"Country: {country}")
    print("Genres:")
    for genre in genres:
        print(f"\t- {genre}")
    print("Actors:")
    for actor in actors:
        print(f"\t- {actor}")

# Example usage
get_movie_info("Baby_Driver")