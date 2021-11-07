package APP;

import MODEL.Aluno;
import java.util.ArrayList;
import VIEW.Menu;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<Aluno> Aluno = new ArrayList<>();
        
        Menu.MenuPrincipal(Aluno);
    }
    
}
