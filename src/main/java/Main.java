import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        MainView.launch(MainView.class);



        // Todo: Eli lisää kontrolleri ja dao. Kontrolleri siis kutsuu daoa, ja hakee kielen perusteella
        // Todo: ne oikeat rivit. Sit updateen joku toinen operaatio, joka lisää tietokantaan sen
        // Todo: uuden rivin oikealla kielellä. Parametreinä siis joku language code ja titteli.

        // Todo: Tietokanta siis siltä kannalta, että operaatiot helppoja. Optimaalisuus on sivujuttu.
    }
}
