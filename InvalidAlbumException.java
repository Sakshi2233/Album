import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InvalidAlbumException extends Exception{

	List<Album>Albums=null;
	public InvalidAlbumException() throws Exception {
	Stream<String>lines=Files.lines(Paths.get("src/Albums.txt"));
	Albums=lines.map(line->{
		String[] record=line.split(",");
		return new Album(record[0],record[1],record[2]);
	}).collect(Collectors.toList());
	
}

}

