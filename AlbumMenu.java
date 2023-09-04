import java.util.Scanner;

public class AlbumMenu {

    private static AlbumDaoImplementation dao;

    static {

        try {

            dao = new AlbumDaoImplementation();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws InvalidAlbumException {
        Scanner sc=new Scanner(System.in);
            while (true) {

                System.out.println("Main Menu");

                System.out.println(
                        "1- add album\n2- Find by Title\n3- List\n4- Find by Artist\n5- Find by Genre\n6- Update\n7- Delete");

                System.out.println("Enter Choice");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        addpersist();

                        break;

                    case 2:

					try {
						findbytitle();
					} catch (InvalidAlbumException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                        break;
                    case 3:

                        list();

                        break;

                    case 4:

                        findbyartist();

                        break;

                    case 5:

                        findbygenre();

                        break;

                    case 6:
                        update();

                        break;

                    case 7:

					try {
						delete();
					} catch (InvalidAlbumException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                        break;
                    default:
                        System.out.println("Invalid Choice");

                }

            }
        }

    private static void list() {

        dao.list().forEach(System.out::println);

    }

    private static void delete() throws InvalidAlbumException {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Album to Delete: ");

            String delete = sc.next();

            System.out.println(dao.delete(delete));
        }

    }

    private static void update() {

    }

    private static void findbygenre() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Genre: ");

            String genre = sc.nextLine();

            System.out.println(dao.findbyGenre(genre));
        }

    }

    private static void findbyartist() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Artist: ");

            String artist = sc.nextLine();

            System.out.println(dao.findbyArtist(artist));
        }

    }

    private static void findbytitle() throws InvalidAlbumException {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Title: ");

            String title = sc.nextLine();

            dao.findbyTitle(title);
        }

    }

    private static void addpersist() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Title: ");
            String title = sc.next();
            System.out.println("Enter Artist: ");
            String artist = sc.next();
            System.out.println("Enter Genre: ");
            String genre = sc.next();
            Album a = new Album(title, artist, genre);
            dao.persist(a);
        }

    }

}