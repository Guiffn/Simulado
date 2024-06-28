import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GerenciamentoDePessoa {

    private String nomeArquivo= "C:\\_ws\\Simulado\\Pessoa.csv";

    public List<Pessoa> getPessoas(){
    List<Pessoa>listaDePessoas=new ArrayList<>();
    Map<String, Pessoa>pessoasmap= new HashMap<>();

    try {
        File arquivoLeitura= new File(nomeArquivo);
        Scanner leitor= new Scanner(arquivoLeitura);

        while (leitor.hasNextLine()){
            String linha =leitor.nextLine();
            String[] dados=linha.split(";");

            String nome= dados[0];
            String codigo= dados[1];
            Pessoa pessoa= new Pessoa(codigo, nome, null, null);
            pessoasmap.put(codigo, pessoa);
        }
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado"+e.getMessage());
       
    }
    String nomeArquivo2= "C:\\_ws\\Simulado\\Endereco.csv";
    
    try{
        File arquivoLeitura= new File(nomeArquivo2);
        Scanner leitor= new Scanner(arquivoLeitura);

        while (leitor.hasNextLine()){
            String linha =leitor.nextLine();
            String[] dados=linha.split(";"); 

            String endereco= dados[0];
            String cidade= dados[1];
            String codigo= dados[2];

            if(pessoasmap.containsKey(codigo)){
                Pessoa pessoa = pessoasmap.get(codigo);
                pessoa.setCidade(cidade);
                pessoa.setEndereco(endereco);
            }else{
                Pessoa pessoa= new Pessoa(codigo, null, endereco, cidade);
                pessoasmap.put(codigo, pessoa);

            }

        }
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo não encontrado"+e.getMessage());
       
    }
    listaDePessoas.addAll(pessoasmap.values());
    return listaDePessoas;
 }

 public void gravarArquivo(List<Pessoa> listaDePessoa){
    try( PrintWriter writer= new PrintWriter(new FileWriter("Dados"))){
        for(Pessoa pessoa:listaDePessoa){
            writer.println(pessoa.toCSV());
        }
        
    } catch (IOException e) {
        System.out.println("Erro de gravação"+e.getMessage());
    }
 }
}
