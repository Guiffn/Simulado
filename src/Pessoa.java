public class Pessoa {
    private String codigo;
    private String nome;
    private String endereco;
    private String cidade;

    public Pessoa(String codigo, String nome, String endereco, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    
    public String toCSV() {
        return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + "]";
    }
    
    
    





}
