import java.util.ArrayList;

public class Cliente {
    
    public int clienteId;
    public String nome;
    public Double cpf;
    public int telefone;
    public String endereco;

    public ArrayList<Comanda> comandas;

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente(
        int clienteId,
        String nome,
        Double cpf,
        int telefone,
        String endereco

    ){
        this.clienteId = clienteId;
        this.nome = nome;
        this. cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;

        this.comandas = new ArrayList<>();
        clientes.add(this);

    }

    public static Cliente verificaId(int clienteId) throws Exception {
        for (Cliente cliente : clientes) {
            if (cliente.clienteId == clienteId) {
                return cliente;
            }
        }

        throw new Exception("Não foi possivel encontrar o CLIENTE");
    }



}

    
