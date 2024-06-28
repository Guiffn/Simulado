import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GerenciamentoDePessoa gerenciamentoDePessoa= new GerenciamentoDePessoa();
        List<Pessoa> pessoas= gerenciamentoDePessoa.getPessoas();
        gerenciamentoDePessoa.gravarArquivo(pessoas);

        
        





    }
}
