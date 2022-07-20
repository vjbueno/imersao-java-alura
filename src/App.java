import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws Exception { 
		
		//realizando uma conexão HTTP e buscando os top 250 filmes;
		String url = "https://alura-imdb-api.herokuapp.com/movies";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		//extraindo alguns dados sobre os filmes do IMDB como titulo, poster e classificação dos filmes
		var parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);
		//System.out.println(listaDeFilmes.size());
		//System.out.println(listaDeFilmes.get(15));
		
		
		//exibindo os dados:
		for (Map<String, String> filme : listaDeFilmes) {
			
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println();
		}
		
		
	}

}
