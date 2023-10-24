import java.util.List;
import java.util.Scanner;

import Caixas.CaixaMercado;
import Caixas.CaixaMercadoDAO;
import Carrinho.Carrinho;
import Fornecedor.Fornecedor;
import Fornecedor.FornecedorDAO;
import Funcionarios.Funcionario;
import Funcionarios.FuncionarioDAO;
import NotaFiscal.NotaFiscal;
import NotaFiscal.NotaFiscalDAO;
import Produtos.Produto;
import Produtos.ProdutoCarne;
import Produtos.ProdutoDAO;
import Produtos.ProdutoLimpeza;
import Produtos.ProdutoVegetal;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int escolha, escolhaListagem, escolhaAdicionar, escolhaExcluir, escolhaModificar;

        System.out.println("===============================================");
        System.out.println("============== SUPERMERCADO ===================");
        System.out.println("===============================================");
        System.out.println("Digite: ");
        System.out.println("1 - Para comecar compras;");
        System.out.println("2 - Para listar dados;");
        System.out.println("3 - Para adicionar dados;");
        System.out.println("4 - Para excluir dados;");
        System.out.println("5 - Para modificar dados;");
        System.out.println("6 - Para comprar de fornecedor;");
        System.out.println("7 - Para sair.");
        escolha = scan.nextInt();
        
        while (escolha != 7) {
            switch(escolha) {
                case 1:
                    int cpfNaNota, seguirComprando, caixaIdVenda;
                    ProdutoDAO produtoDAOCompra = new ProdutoDAO();
                    Carrinho carrinho = new Carrinho();
                    CaixaMercado caixaMercadoVenda = new CaixaMercado();
                    CaixaMercadoDAO caixaMercadoDAOVenda = new CaixaMercadoDAO();
                    System.out.println("Digite o id do caixa: ");
                    caixaIdVenda = scan.nextInt();
                    caixaMercadoVenda = caixaMercadoDAOVenda.buscarCaixaMercadoPorId(caixaIdVenda);
                    System.out.println("Digite o nome ");
                    System.out.println("Digite o nome do cliente: ");
                    carrinho.setCliente(scan.next());
                    System.out.println("Deseja o cpf na nota? Digite 1 para sim e 0 para nao:");
                    cpfNaNota = scan.nextInt();
                    while (cpfNaNota != 1 || cpfNaNota != 0) {
                        if (cpfNaNota == 1) {
                            System.out.println("Digite seu cpf: ");
                            carrinho.setCpf(scan.next());                      
                        }
                    }
                    do {
                        produtoDAOCompra.listarProdutos();
                        System.out.println("Digite o nome do produto que deseja comprar: ");
                        carrinho.adicionarProdutoAoCarrinho(produtoDAOCompra.buscarProdutoPorNome(scan.next()));
                        System.out.println("Deseja continuar comprando? Digite 1 para sim e 0 para nao: ");
                        seguirComprando = scan.nextInt();
                    } while (seguirComprando != 0);
                    // tirar um do estoque

                    for (Produto produto : carrinho.getProdutos()) {
                        produto.setEstoque(produto.getEstoque() - 1);
                    }

                    caixaMercadoVenda.receberPagamento(carrinho.gerarPrecoTotal());
                    caixaMercadoDAOVenda.atualizarCaixaMercado(caixaMercadoVenda);
                    break;
                case 2:
                    System.out.println("Digite: ");
                    System.out.println("1 - Para listar produtos;");
                    System.out.println("2 - Para listar fornecedores;");
                    System.out.println("3 - Para listar funcionarios.");
                    System.out.println("4 - Para sair.");
                    escolhaListagem = scan.nextInt();
                    while (escolhaListagem != 4) {
                        switch(escolhaListagem) {
                            case 1:
                                ProdutoDAO produtoDAOListagem = new ProdutoDAO();
                                produtoDAOListagem.listarProdutos();
                                break;
                            case 2:
                                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                                fornecedorDAO.listarFornecedores();
                                break;
                            case 3:
                                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                funcionarioDAO.listarFuncionarios();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                        break;
                    }
                case 3:
                    System.out.println("Digite: ");
                    System.out.println("1 - Para adicionar produto;");
                    System.out.println("2 - Para adicionar fornecedor;");
                    System.out.println("3 - Para adicionar funcionario.");
                    System.out.println("4 - Para sair.");
                    escolhaAdicionar = scan.nextInt();

                    while (escolhaAdicionar != 4) {
                        switch(escolhaAdicionar) {
                            case 1:
                                System.out.println("Digite: ");
                                System.out.println("1 - Para adicionar produto de carne;");
                                System.out.println("2 - Para adicionar produto de limpeza;");
                                System.out.println("3 - Para adicionar produto vegetal.");
                                System.out.println("4 - Para sair.");
                                escolhaAdicionar = scan.nextInt();
                                while (escolhaAdicionar != 4) {
                                    ProdutoDAO produtoDAOInsercao = new ProdutoDAO();

                                    switch(escolhaAdicionar) {
                                        case 1:
                                            ProdutoCarne produtoCarne = new ProdutoCarne();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoCarne.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoCarne.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoCarne.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto: ");
                                            produtoCarne.setValidade(scan.next());
                                            System.out.println("Digite o corte do produto: ");
                                            produtoCarne.setCorte(scan.next());
                                            System.out.println("Digite o peso do produto: ");
                                            produtoCarne.setPeso(scan.nextFloat());
                                            produtoDAOInsercao.salvarProduto(produtoCarne);
                                            break;
                                        case 2:
                                            ProdutoLimpeza produtoLimpeza = new ProdutoLimpeza();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoLimpeza.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoLimpeza.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoLimpeza.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto(caso nao tenha validade, digite 'null'): ");
                                            produtoLimpeza.setValidade(scan.next());
                                            if (produtoLimpeza.getValidade().equals("null")) {
                                                produtoLimpeza.setValidade(null);
                                            }
                                            System.out.println("Digite o volume do produto: ");
                                            produtoLimpeza.setVolume(scan.nextInt());
                                            System.out.println("Digite a finalidade do produto: ");
                                            produtoLimpeza.setFinalidade(scan.next());
                                            produtoDAOInsercao.salvarProduto(produtoLimpeza);
                                            break;
                                        case 3:
                                            ProdutoVegetal produtoVegetal = new ProdutoVegetal();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoVegetal.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoVegetal.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoVegetal.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto: ");
                                            produtoVegetal.setValidade(scan.next());
                                            System.out.println("Digite o tipo do produto: ");
                                            produtoVegetal.setTipo(scan.next());
                                            System.out.println("Digite o peso do produto: ");
                                            produtoVegetal.setPeso(scan.nextFloat());
                                            produtoDAOInsercao.salvarProduto(produtoVegetal);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Opcao invalida!");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                                Fornecedor fornecedor = new Fornecedor();
                                System.out.println("Digite o cnpj do fornecedor: ");
                                fornecedor.setCnpj(scan.next());
                                System.out.println("Digite o nome do fornecedor: ");
                                fornecedor.setNome(scan.next());
                                System.out.println("Digite o tipo de produto do fornecedor: ");
                                fornecedor.setTipoProduto(scan.next());
                                System.out.println("Digite o custo do fornecedor: ");
                                fornecedor.setCusto(scan.nextFloat());
                                System.out.println("Digite a origem do fornecedor: ");
                                fornecedor.setOrigem(scan.next());
                                fornecedorDAO.salvarFornecedor(fornecedor);
                                break;
                            case 3:
                                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                Funcionario funcionario = new Funcionario();
                                System.out.println("Digite o cpf do funcionario: ");
                                funcionario.setCpf(scan.next());
                                System.out.println("Digite o cargo do funcionario: ");
                                funcionario.setCargo(scan.next());
                                System.out.println("Digite o salario do funcionario: ");
                                funcionario.setSalario(scan.nextFloat());
                                System.out.println("Digite o departamento do funcionario: ");
                                funcionario.setDepartamento(scan.next());
                                funcionarioDAO.salvarFuncionario(funcionario);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite: ");
                    System.out.println("1 - Para excluir produto;");
                    System.out.println("2 - Para excluir fornecedor;");
                    System.out.println("3 - Para excluir funcionario.");
                    System.out.println("4 - Para sair.");
                    escolhaExcluir = scan.nextInt();

                    while (escolhaExcluir != 4) {
                        switch(escolhaExcluir) {
                            case 1:
                                ProdutoDAO produtoDAOExclusao = new ProdutoDAO();
                                System.out.println("Digite o nome do produto: ");
                                produtoDAOExclusao.removerProduto(scan.next());
                                break;
                            case 2:
                                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                                System.out.println("Digite o cnpj do fornecedor: ");
                                fornecedorDAO.removerFornecedor(scan.next());
                                break;
                            case 3:
                                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                System.out.println("Digite o cpf do funcionario: ");
                                funcionarioDAO.removerFuncionario(scan.next());
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Digite: ");
                    System.out.println("1 - Para modificar produto;");
                    System.out.println("2 - Para modificar fornecedor;");
                    System.out.println("3 - Para modificar funcionario.");
                    System.out.println("4 - Para sair.");
                    escolhaModificar = scan.nextInt();

                    while (escolhaModificar != 4) {
                        switch(escolhaModificar) {
                            case 1:
                                System.out.println("Digite: ");
                                System.out.println("1 - Para modificar produto de carne;");
                                System.out.println("2 - Para modificar produto de limpeza;");
                                System.out.println("3 - Para modificar produto vegetal.");
                                System.out.println("4 - Para sair.");
                                escolhaModificar = scan.nextInt();

                                while (escolhaModificar != 4) {
                                    ProdutoDAO produtoDAOModificacao = new ProdutoDAO();
                                    switch(escolhaModificar) {
                                        case 1:
                                            ProdutoCarne produtoCarne = new ProdutoCarne();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoCarne.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoCarne.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoCarne.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto: ");
                                            produtoCarne.setValidade(scan.next());
                                            System.out.println("Digite o corte do produto: ");
                                            produtoCarne.setCorte(scan.next());
                                            System.out.println("Digite o peso do produto: ");
                                            produtoCarne.setPeso(scan.nextFloat());
                                            produtoDAOModificacao.atualizarProduto(produtoCarne);
                                            break;
                                        case 2:
                                            ProdutoLimpeza produtoLimpeza = new ProdutoLimpeza();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoLimpeza.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoLimpeza.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoLimpeza.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto(caso nao tenha validade, digite 'null'): ");
                                            produtoLimpeza.setValidade(scan.next());
                                            if (produtoLimpeza.getValidade().equals("null")) {
                                                produtoLimpeza.setValidade(null);
                                            }
                                            System.out.println("Digite o volume do produto: ");
                                            produtoLimpeza.setVolume(scan.nextInt());
                                            System.out.println("Digite a finalidade do produto: ");
                                            produtoLimpeza.setFinalidade(scan.next());
                                            produtoDAOModificacao.atualizarProduto(produtoLimpeza);
                                            break;
                                        case 3:
                                            ProdutoVegetal produtoVegetal = new ProdutoVegetal();
                                            System.out.println("Digite o nome do produto: ");
                                            produtoVegetal.setNome(scan.next());
                                            System.out.println("Digite o preco do produto: ");
                                            produtoVegetal.setPreco(scan.nextFloat());
                                            System.out.println("Digite o estoque do produto: ");
                                            produtoVegetal.setEstoque(scan.nextInt());
                                            System.out.println("Digite a validade do produto: ");
                                            produtoVegetal.setValidade(scan.next());
                                            System.out.println("Digite o tipo do produto: ");
                                            produtoVegetal.setTipo(scan.next());
                                            System.out.println("Digite o peso do produto: ");
                                            produtoVegetal.setPeso(scan.nextFloat());
                                            produtoDAOModificacao.atualizarProduto(produtoVegetal);
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Opcao invalida!");
                                            break;

                                    }
                                }
                            case 2:
                                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                                Fornecedor fornecedor = new Fornecedor();
                                System.out.println("Digite o cnpj do fornecedor: ");
                                fornecedor.setCnpj(scan.next());
                                System.out.println("Digite o nome do fornecedor: ");
                                fornecedor.setNome(scan.next());
                                System.out.println("Digite o tipo de produto do fornecedor: ");
                                fornecedor.setTipoProduto(scan.next());
                                System.out.println("Digite o custo do fornecedor: ");
                                fornecedor.setCusto(scan.nextFloat());
                                System.out.println("Digite a origem do fornecedor: ");
                                fornecedor.setOrigem(scan.next());
                                fornecedorDAO.atualizarFornecedor(fornecedor);
                                break;
                            
                            case 3:
                                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                                Funcionario funcionario = new Funcionario();
                                System.out.println("Digite o cpf do funcionario: ");
                                funcionario.setCpf(scan.next());
                                System.out.println("Digite o cargo do funcionario: ");
                                funcionario.setCargo(scan.next());
                                System.out.println("Digite o salario do funcionario: ");
                                funcionario.setSalario(scan.nextFloat());
                                System.out.println("Digite o departamento do funcionario: ");
                                funcionario.setDepartamento(scan.next());
                                funcionarioDAO.atualizarFuncionario(funcionario);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcao invalida!");
                                break;
                        }
                    }
                case 6:
                    CaixaMercado caixaMercadoCompra = new CaixaMercado();
                    CaixaMercadoDAO caixaMercadoDAO = new CaixaMercadoDAO();
                    int caixaIdCompra;
                    System.out.println("Digite o id do caixa: ");
                    caixaIdCompra = scan.nextInt();
                    caixaMercadoCompra = caixaMercadoDAO.buscarCaixaMercadoPorId(caixaIdCompra);

                    Fornecedor fornecedor = new Fornecedor();
                    FornecedorDAO fornecedorDAO = new FornecedorDAO();
                    System.out.println("Digite o nome do fornecedor: ");
                    fornecedor.setNome(scan.next());
                    for (Fornecedor f : fornecedorDAO.listarFornecedores()) {
                        if (fornecedor.getNome().equals(fornecedor.getNome())) {
                            fornecedor = f;
                        }
                    caixaMercadoCompra.comprarProdutoDeFornecedor(fornecedor);
                    caixaMercadoDAO.atualizarCaixaMercado(caixaMercadoCompra);
                    }
                    break;
                case 7:
                    break;
            }
        }
    }
}