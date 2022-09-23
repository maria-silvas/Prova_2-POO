import java.util.ArrayList;

public class Comanda {
    
    public int comandaId;
    public int num;
    public String dt;
    public int clienteId;


    public Cliente cliente;
    public ArrayList<Pizza> pizzas;
    public static ArrayList<Comanda> comandas = new ArrayList<Comanda>();

    public Comanda(

        int comandaId,
        int num,
        String dt,
        Cliente cliente

    ){

        this.comandaId = comandaId;
        this.num = num;
        this.dt = dt;
        this.clienteId = cliente.clienteId;
        this.cliente = cliente;
        

        this.pizzas = new ArrayList<Pizza>();
        cliente.comandas.add(this);
        comandas.add(this);

    }

    public static Comanda verificaId(int comandaId) throws Exception {
        for (Comanda comanda : comandas) {
            if (comanda.comandaId == comandaId) {
                return comanda;
            }
        }

        throw new Exception("Não foi possivel encontrar a COMANDA");
    }

}
