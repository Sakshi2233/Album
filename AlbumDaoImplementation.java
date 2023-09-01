import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class AlbumDaoImplementation implements AlbumDao {
	List<Album>Albums=null;
	public AlbumDaoImplementation() throws Exception {
	Stream<String>lines=Files.lines(Paths.get("src/Albums.txt"));
	Albums=lines.map(line->{
		String[] record=line.split(",");
		return new Album(record[0],record[1],record[2]);
	}).collect(Collectors.toList());
	System.out.println(Albums);
	}
	@Override
	public void persist(Album a) {
		Albums.add(a);
		
	}

	@Override
	public Album findbyTitle(String title) {
		return Albums.stream().filter(a->a.getTitle().equals(title)).findFirst().get();
	}

	@Override
	public List<Album> list() {
		
		return Albums;
	}

	@Override
	public Album findbyArtist(String artist) {
		return Albums.stream().filter(a->a.getArtist().equals(artist)).findFirst().get();
	}

	@Override
	public Album findbyGenre(String genre) {
		return Albums.stream().filter(a->a.getGenre().equals(a)).findFirst().get();
	}



	
	public boolean delete(String title) {
		return Albums.removeIf(a->a.getTitle()==title);
	}
	@Override
	public boolean update(Album a) {
		// TODO Auto-generated method stub
		return false;
	}


	

	
}
