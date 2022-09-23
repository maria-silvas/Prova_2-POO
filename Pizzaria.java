import java.util.Scanner;

public class Pizzaria {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int menu = 0;

        do {
            System.out.println("PIZZARIA DO SEU ZÉ");

            System.out.println("{1} ->> Cadastrar Clientes:");
            System.out.println("{2} ->> Listar Clientes:");
            System.out.println("{3} ->> Cadastrar Sabor:");
            System.out.println("{4} ->> Listar Sabor:");
            System.out.println("{5} ->> Cadastrar Comanda:");
            System.out.println("{6} ->> Listar Comanda:");
            System.out.println("{7} ->> SAIR:\n");

            System.out.print("Informe o numero: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                
                    try {
                        System.out.print("Digite o id: ");
                        int clienteId = scanner.nextInt();
                        System.out.print("Digite o Nome: ");
                        String nome = scanner.next();
                        System.out.print("Digite o CPF: ");
                        Double cpf = scanner.nextDouble();
                        System.out.print("Digite o Telefone: ");
                        int telefone = scanner.nextInt();
                        System.out.print("\nDigite o Endereco: ");
                        String endereco = scanner.next();

                        Cliente cliente = new Cliente(clienteId, nome, cpf, telefone, endereco);
                       
                        System.out.println("\nId: " + cliente.clienteId + "\n" + "Nome: " + cliente.nome + "\n" + "Cpf: " + cliente.cpf + "\n" + "Telefone: " + cliente.telefone + "\n" + "Endereco: " + cliente.endereco + "\n");


                        
                    } catch (Exception error) {
                        System.out.println("ERRO ao cadastrar cliente!" + error.getMessage());
                    }   

                    break;
                    
                case 2:
                    for (Cliente cliente : Cliente.clientes) {
                        System.out.println("\nId: " + cliente.clienteId + "\n" + "Nome: " + cliente.nome + "\n" + "Cpf: " + cliente.cpf + "\n" + "Telefone: " + cliente.telefone + "\n" + "Endereco: " + cliente.endereco + "\n");
                    }

                    break;

                case 3:
                
                    try {
                        
                        System.out.print("\nDigite o ID: ");
                        int idSabor = scanner.nextInt();
                        System.out.print("\nDigite a Descricao: ");
                        String descricao = scanner.next();
                        System.out.print("\nDigite o Detalhamento/ingredientes: ");
                        String detalhamento = scanner.next();

                        Sabor sabor = new Sabor(idSabor, descricao, detalhamento);
                        System.out.println("\nId: " + sabor.idSabor + "\n" + "Descricao: " + sabor.descricao + "\n" + "Detalhamento: " + sabor.detalhamento + "\n");

                    } catch (Exception error) {
                        System.out.println("Erro ao cadastrar Sabor." + error.getMessage());
                    }

                    break;

                case 4:
                    for (Sabor sabor : Sabor.sabores) {
                      System.out.println("\nId: " + sabor.idSabor + "\n" + "Descricao: " + sabor.descricao + "\n" + "Detalhamento: " + sabor.detalhamento + "\n");
                    }

                    break;
                
                case 5:
                
                    try {
                        
                        System.out.print("Informe o ID da Comanda: ");
                        int comandaId = scanner.nextInt();
                        System.out.print("Informe o ID do Cliente: ");
                        int clienteId = scanner.nextInt();
                        Cliente cliente = Cliente.verificaId(clienteId);
                        System.out.print("Informe o numero: ");
                        int num = scanner.nextInt();
                        System.out.print("Informe a Data de Hoje: ");
                        String dt = scanner.next();
                        Comanda comanda = new Comanda(comandaId, num, dt, cliente);

                        
                        System.out.print("\nQuantidade de pizzas que deseja: ");
                        int qtePizza = scanner.nextInt();

                        for (int i = 0; i < qtePizza; i++) {
                            boolean xPizza = false;
                            int PizzaId = 0;
                            do {
                                System.out.print("\nDigite o ID da Pizza: ");
                                PizzaId = scanner.nextInt();
                                try {
                                    Pizza.verificaId(PizzaId);
                                    xPizza = true;
                                    System.out.println("Id já existente");

                                } catch (Exception e) {
                                    xPizza = false;
                                }

                            } while (xPizza);
    
                            System.out.print("Informe o tamanho da Pizza: ");
                            String tamanho = scanner.next();
                            
                            System.out.print("Informe o ID do Sabor: ");
                            int idSabor = scanner.nextInt();
                            Sabor sabor = Sabor.verificaId(idSabor);

                            Pizza pizza = new Pizza(comanda, PizzaId, tamanho, qtePizza, sabor);
                            System.out.println("\nId Comanda: " + comanda.comandaId + "\n" + "Numero: " + comanda.num + "\n" + "Data: " + comanda.dt + "\n" + "Qnts Pizzas: " + pizza.qtePizza + "\n" + "Id Pizza: " + pizza.PizzaId + "\n" + "Tamanho: " + pizza.tamanho + "\n");
                        }

                        break;

                    } catch (Exception error) {
                        System.out.println("Erro ao cadastrar a comanda." + error.getMessage());
                    }
                    
                case 6:
                        for (Pizza pizza : Pizza.pizzas){
                            System.out.println("\nQuantas Pizzas: " + pizza.qtePizza + "\n" + "Id Pizza: " + pizza.PizzaId + "\n" + "Tamanho: " + pizza.tamanho + "\n");
                        }
                        for (Comanda comanda : Comanda.comandas) {
                            System.out.println("\nId Comanda: " + comanda.comandaId + "\n" + "Numero: " + comanda.num + "\n" + "Data: " + comanda.dt + "\n");
                    }
                    break;

                case 7:
                    System.out.println("\nObrigada!\n");

                    break;

                default:
                        System.out.println("Operacao Invalida!");

                    break;
            }


        } while (menu != 0);

        scanner.close();




    }


}
