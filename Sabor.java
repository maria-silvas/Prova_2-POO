import java.util.ArrayList;

public class Sabor {
    
    public int idSabor;
    public String descricao;
    public String detalhamento;
    public ArrayList<Pizza> pizzas;

    public static ArrayList<Sabor> sabores = new ArrayList<Sabor>();

    public Sabor(

        int idSabor,
        String descricao,
        String detalhamento

    ){

        this.idSabor = idSabor;
        this.descricao = descricao;
        this.detalhamento = detalhamento;
        this.pizzas = new ArrayList<Pizza>();
        
        sabores.add(this);

    }

    public static Sabor verificaId(int idSabor) throws Exception {
        for (Sabor sabor : sabores) {
            if (sabor.idSabor == idSabor) {
                return sabor;
            }
        }

        throw new Exception("Sabor não encontrado");
    }



}
