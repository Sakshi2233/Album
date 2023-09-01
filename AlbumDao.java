import java.util.List;

public interface AlbumDao {
     public void persist(Album a);
	
	public Album findbyTitle(String title) throws InvalidAlbumException;
	public List<Album>list();
	public Album findbyArtist(String artist) ;
	public Album findbyGenre(String genre) ;

    
	boolean update(Album a);
    boolean delete(String title) throws InvalidAlbumException;



}
	
	


